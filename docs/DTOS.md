# 🔄 Transformación de DTOs - Estrategias de Mapeo Entre Capas

## Visión General

En la **Arquitectura Hexagonal**, la transformación de datos entre capas es fundamental para mantener el aislamiento y la integridad de cada nivel. El sistema implementa múltiples tipos de objetos que requieren transformaciones precisas y eficientes.

## 🎯 Tipos de Objetos en el Sistema

### 1. **Domain Models** - Núcleo de Negocio
```java
// Modelo de dominio puro
public class Patient extends Person {
    private Long id;
    private String fullName;
    private int age;
    private Gender gender;
    private EmergencyContact emergencyContact;  // Objeto complejo
    private Insurance insurance;                // Relación de negocio
    
    // Lógica de negocio
    public boolean hasActiveInsurance() {
        return insurance != null && insurance.isPolicyActive();
    }
    
    public boolean isEligibleForSeniorDiscount() {
        return age >= 65;
    }
}
```

### 2. **JPA Entities** - Persistencia
```java
// Entidad optimizada para base de datos
@Entity
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "gender")
    private String gender;                      // Enum serializado como String
    
    @Column(name = "emergency_contact_id")
    private Long emergencyContactId;            // Solo FK, no objeto
    
    @Column(name = "insurance_id")
    private Long insuranceId;                   // Referencia simple
    
    // Sin lógica de negocio, solo getters/setters
}
```

### 3. **REST DTOs** - API Externa
```java
// DTOs para comunicación HTTP
public class CreatePatientRequest {
    public String fullName;
    public int age;
    public String gender;
    public CreateEmergencyContactRequest emergencyContact;
    public CreateInsuranceRequest insurance;
    
    // Estructura anidada para facilitar JSON
}

public class CreatePatientResponse {
    public String message;
    public PatientSummaryDTO patient;
    
    public CreatePatientResponse(String message, Patient patient) {
        this.message = message;
        this.patient = PatientSummaryDTO.from(patient);
    }
}
```

## 🔄 Flujo Completo de Transformación

### Request → Domain → Entity → Domain → Response

```
HTTP Request (JSON)
       ↓
   REST DTO (CreatePatientRequest)
       ↓ [REST Mapper]
   Domain Model (Patient)
       ↓ [Use Case]
   Domain Model (Patient)
       ↓ [Persistence Mapper]
   JPA Entity (PatientEntity)
       ↓ [JPA Repository]
   Base de Datos (MySQL)
       ↓ [JPA Repository]
   JPA Entity (PatientEntity)
       ↓ [Persistence Mapper]
   Domain Model (Patient)
       ↓ [REST Mapper]
   REST DTO (CreatePatientResponse)
       ↓
HTTP Response (JSON)
```

## 🏗️ Implementación de Mappers por Capa

### 1. **REST Layer Mappers**

#### AdminMapper - Transformación API ↔ Domain

```java
public class AdminMapper {
    
    // Request DTO → Domain Model
    public Patient toPatient(AdminController.CreatePatientRequest req) {
        if (req.patient == null) return null;
        
        Patient domain = new Patient();
        domain.setFullName(req.patient.getFullName());
        domain.setAge(req.patient.getAge());
        domain.setGender(req.patient.getGender());
        domain.setAddress(req.patient.getAddress());
        domain.setPhone(req.patient.getPhone());
        domain.setEmail(req.patient.getEmail());
        
        // Transformar objetos anidados
        if (req.patient.getEmergencyContact() != null) {
            domain.setEmergencyContact(
                toEmergencyContact(req.patient.getEmergencyContact())
            );
        }
        
        return domain;
    }
    
    // Domain Model → Response DTO
    public CreatePatientResponse toResponse(Patient patient, String message) {
        return new CreatePatientResponse(message, patient);
    }
    
    // Mapeo de objetos complejos
    private EmergencyContact toEmergencyContact(EmergencyContactDTO dto) {
        EmergencyContact contact = new EmergencyContact();
        contact.setName(dto.name);
        contact.setPhone(dto.phone);
        contact.setRelationship(dto.relationship);
        return contact;
    }
}
```

#### Estrategias de Mapeo REST

**1. DTOs como Clases Internas**
```java
public class AdminController {
    
    // Agrupación por contexto
    public static class CreatePatientRequest { 
        public Patient patient; 
    }
    
    public static class CreatePatientResponse { 
        public String message; 
        public Patient patient; 
        
        public CreatePatientResponse(String m, Patient p) {
            this.message = m; 
            this.patient = p;
        }
    }
}
```

**Ventajas:**
- ✅ Agrupación lógica por controlador
- ✅ Menos archivos en el proyecto
- ✅ Fácil identificación de contexto

**Desventajas:**
- ❌ Archivos grandes si muchos endpoints
- ❌ Reutilización limitada entre controladores

**2. DTOs en Archivos Separados**
```java
// Archivo: CreatePatientRequest.java
public class CreatePatientRequest {
    @NotNull
    @Size(min = 2, max = 100)
    public String fullName;
    
    @Min(0) @Max(150)
    public int age;
    
    @Pattern(regexp = "MALE|FEMALE|OTHER")
    public String gender;
    
    // Validaciones incluidas
}
```

### 2. **Persistence Layer Mappers**

#### PatientMapper - Transformación Domain ↔ Entity

```java
public class PatientMapper {
    
    // Entity → Domain (Lectura de BD)
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;
        
        Patient domain = new Patient();
        domain.setId(entity.getId());
        domain.setFullName(entity.getFullName());
        domain.setAge(entity.getAge());
        
        // Conversión de enum con manejo de errores
        if (entity.getGender() != null) {
            try { 
                domain.setGender(Gender.valueOf(entity.getGender())); 
            } catch (IllegalArgumentException ex) { 
                logger.warn("Invalid gender value: {}", entity.getGender());
                domain.setGender(Gender.OTHER); // Valor por defecto
            }
        }
        
        // Referencias externas se cargan separadamente
        // (para evitar N+1 queries)
        
        return domain;
    }
    
    // Domain → Entity (Escritura a BD)
    public static PatientEntity toEntity(Patient domain) {
        if (domain == null) return null;
        
        PatientEntity entity = new PatientEntity();
        if (domain.getId() != 0) entity.setId(domain.getId());
        entity.setFullName(domain.getFullName());
        entity.setAge(domain.getAge());
        entity.setGender(domain.getGender() != null ? 
                          domain.getGender().name() : null);
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setEmail(domain.getEmail());
        
        return entity;
    }
    
    // Mapeo con relaciones cargadas
    public static Patient toDomainWithRelations(PatientEntity entity, 
                                               EmergencyContact contact, 
                                               Insurance insurance) {
        Patient domain = toDomain(entity);
        if (domain != null) {
            domain.setEmergencyContact(contact);
            domain.setInsurance(insurance);
        }
        return domain;
    }
}
```

### 3. **Mappers Bidireccionales Complejos**

#### Mapeo de Objetos con Relaciones

```java
public class MedicalRecordMapper {
    
    // Mapeo completo con relaciones
    public static MedicalRecord toDomain(MedicalRecordEntity entity,
                                        Patient patient,
                                        User doctor) {
        if (entity == null) return null;
        
        MedicalRecord record = new MedicalRecord();
        record.setId(entity.getId());
        record.setDiagnosis(entity.getDiagnosis());
        record.setTreatment(entity.getTreatment());
        record.setObservations(entity.getObservations());
        record.setCreatedDate(entity.getCreatedDate());
        
        // Asignar relaciones cargadas
        record.setPatient(patient);
        record.setDoctor(doctor);
        
        return record;
    }
    
    // Mapeo para actualización (preserva relaciones)
    public static void updateEntityFromDomain(MedicalRecordEntity entity, 
                                            MedicalRecord domain) {
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setTreatment(domain.getTreatment());
        entity.setObservations(domain.getObservations());
        
        // IDs de relaciones no se cambian en updates
        // Solo se actualiza contenido
    }
}
```

## 🛠️ Herramientas de Mapeo Avanzadas

### 1. **MapStruct** - Generación Automática

```java
@Mapper(componentModel = "spring")
public interface PatientMapStruct {
    
    @Mapping(source = "gender", target = "gender", 
             qualifiedByName = "stringToGender")
    Patient entityToDomain(PatientEntity entity);
    
    @Mapping(source = "gender", target = "gender", 
             qualifiedByName = "genderToString")
    PatientEntity domainToEntity(Patient domain);
    
    @Named("stringToGender")
    default Gender stringToGender(String gender) {
        return gender != null ? Gender.valueOf(gender) : null;
    }
    
    @Named("genderToString")
    default String genderToString(Gender gender) {
        return gender != null ? gender.name() : null;
    }
}
```

**Ventajas de MapStruct:**
- ✅ Generación automática en tiempo de compilación
- ✅ Alto rendimiento (sin reflexión)
- ✅ Detección de errores en tiempo de compilación
- ✅ Mapeo de objetos complejos

### 2. **ModelMapper** - Mapeo por Convención

```java
@Configuration
public class MapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        
        // Configuración personalizada
        mapper.getConfiguration()
              .setMatchingStrategy(MatchingStrategies.STRICT)
              .setFieldMatchingEnabled(true)
              .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        
        // Mapeos específicos
        mapper.createTypeMap(PatientEntity.class, Patient.class)
              .addMapping(src -> src.getGender(), 
                         (dest, value) -> dest.setGender(Gender.valueOf((String) value)));
        
        return mapper;
    }
}
```

### 3. **Mapeo Manual Optimizado** (Implementación Actual)

```java
public class OptimizedPatientMapper {
    
    private static final Logger logger = LoggerFactory.getLogger(OptimizedPatientMapper.class);
    
    // Pool de objetos para reducir allocations
    private static final ThreadLocal<Patient> PATIENT_POOL = 
        ThreadLocal.withInitial(Patient::new);
    
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;
        
        Patient domain = new Patient(); // O usar pool: PATIENT_POOL.get()
        
        // Mapeo directo sin validaciones costosas
        domain.setId(entity.getId());
        domain.setFullName(entity.getFullName());
        domain.setAge(entity.getAge());
        
        // Mapeo de enum optimizado
        domain.setGender(mapGender(entity.getGender()));
        
        return domain;
    }
    
    private static Gender mapGender(String gender) {
        if (gender == null) return null;
        
        // Switch más rápido que valueOf con try-catch
        switch (gender) {
            case "MALE": return Gender.MALE;
            case "FEMALE": return Gender.FEMALE;
            case "OTHER": return Gender.OTHER;
            default:
                logger.warn("Unknown gender: {}", gender);
                return Gender.OTHER;
        }
    }
}
```

## 📊 Estrategias de Optimización

### 1. **Lazy Loading de Relaciones**

```java
// En vez de cargar todo junto
public Patient findPatientWithAll(Long id) {
    PatientEntity entity = repository.findById(id);
    EmergencyContact contact = emergencyRepository.findByPatientId(id);
    Insurance insurance = insuranceRepository.findByPatientId(id);
    return PatientMapper.toDomainWithRelations(entity, contact, insurance);
}

// Cargar solo lo necesario
public Patient findPatientBasic(Long id) {
    PatientEntity entity = repository.findById(id);
    return PatientMapper.toDomain(entity); // Sin relaciones
}
```

### 2. **Batching de Transformaciones**

```java
public List<Patient> findAllPatients() {
    List<PatientEntity> entities = repository.findAll();
    
    // Mapeo en lote (más eficiente)
    return entities.stream()
                   .map(PatientMapper::toDomain)
                   .collect(Collectors.toList());
}
```

### 3. **Caching de Mapeos Costosos**

```java
@Component
public class CachedPatientMapper {
    
    @Cacheable(value = "patient-mappings", key = "#entity.id")
    public Patient toDomain(PatientEntity entity) {
        return PatientMapper.toDomain(entity);
    }
}
```

## 🧪 Testing de Mappers

### Test de Transformación Bidireccional

```java
@Test
void mapperShouldPreserveDataIntegrity() {
    // Arrange
    Patient original = createTestPatient();
    
    // Act: Domain → Entity → Domain
    PatientEntity entity = PatientMapper.toEntity(original);
    Patient mapped = PatientMapper.toDomain(entity);
    
    // Assert: Datos preservados
    assertThat(mapped.getId()).isEqualTo(original.getId());
    assertThat(mapped.getFullName()).isEqualTo(original.getFullName());
    assertThat(mapped.getGender()).isEqualTo(original.getGender());
}

@Test
void mapperShouldHandleNullValues() {
    // Arrange
    PatientEntity entityWithNulls = new PatientEntity();
    entityWithNulls.setId(1L);
    entityWithNulls.setGender(null);
    
    // Act
    Patient mapped = PatientMapper.toDomain(entityWithNulls);
    
    // Assert
    assertThat(mapped).isNotNull();
    assertThat(mapped.getGender()).isNull();
}
```

### Test de Performance

```java
@Test
void mapperPerformanceTest() {
    // Arrange
    List<PatientEntity> entities = createLargeEntityList(10000);
    
    // Act
    long startTime = System.currentTimeMillis();
    List<Patient> patients = entities.stream()
                                    .map(PatientMapper::toDomain)
                                    .collect(Collectors.toList());
    long endTime = System.currentTimeMillis();
    
    // Assert
    assertThat(patients).hasSize(10000);
    assertThat(endTime - startTime).isLessThan(1000); // < 1 segundo
}
```

## 📋 Mejores Prácticas

### ✅ Hacer

1. **Validar Nulls**: Siempre manejar valores nulos
2. **Logging de Errores**: Registrar transformaciones fallidas
3. **Testing Exhaustivo**: Probar casos edge
4. **Documentar Mapeos**: Explicar transformaciones complejas
5. **Optimizar Performance**: Medir y optimizar mapeos costosos

### ❌ Evitar

1. **Mapeo Reflexivo en Producción**: Usar solo para desarrollo
2. **Transformaciones con Side Effects**: Mappers deben ser puros
3. **Dependencias Circulares**: Entre mappers de diferentes capas
4. **Mapeo de Todo**: Solo transformar lo necesario
5. **Hardcoding**: Valores mágicos en transformaciones

## 🚀 Evolución del Sistema de Mapeo

### Migración a MapStruct

```java
// Fase 1: Coexistencia
@Component
public class HybridPatientMapper {
    
    @Autowired
    private PatientMapStruct mapStruct;
    
    public Patient toDomain(PatientEntity entity) {
        // Usar MapStruct para casos simples
        if (isSimpleCase(entity)) {
            return mapStruct.entityToDomain(entity);
        }
        
        // Usar mapeo manual para casos complejos
        return PatientMapper.toDomain(entity);
    }
}
```

### Métricas de Mapeo

```java
@Component
public class MappingMetrics {
    
    private final MeterRegistry meterRegistry;
    
    public Patient toDomain(PatientEntity entity) {
        Timer.Sample sample = Timer.start(meterRegistry);
        
        try {
            Patient result = PatientMapper.toDomain(entity);
            meterRegistry.counter("mapping.success", "type", "patient").increment();
            return result;
        } catch (Exception e) {
            meterRegistry.counter("mapping.error", "type", "patient").increment();
            throw e;
        } finally {
            sample.stop(Timer.builder("mapping.duration")
                           .tag("type", "patient")
                           .register(meterRegistry));
        }
    }
}
```

---

Este sistema de transformación garantiza que cada capa mantenga su integridad y responsabilidad específica, mientras proporciona un intercambio de datos eficiente y confiable entre todos los niveles de la arquitectura.
