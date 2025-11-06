# 🗄️ Persistencia y JPA - Mapeo Objeto-Relacional

## Visión General

La capa de **Persistencia** implementa el patrón **Repository** usando **Spring Data JPA** para el mapeo objeto-relacional. Esta capa actúa como adaptador de salida en la arquitectura hexagonal, permitiendo que el dominio persista datos sin conocer los detalles de la base de datos.

## 🏗️ Arquitectura de Persistencia

```
Infrastructure/Persistence/
├── entities/           # Entidades JPA (@Entity)
├── repositories/       # Interfaces JPA Repository
├── mappers/           # Transformación Domain ↔ JPA Entity
└── adapters/          # Implementación de puertos de dominio
```

## 📊 Modelo de Base de Datos

### Diagrama de Entidades

```sql
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│     PATIENT     │────│   VISIT         │────│ MEDICAL_RECORD  │
│                 │    │                 │    │                 │
│ id (PK)         │    │ id (PK)         │    │ id (PK)         │
│ full_name       │    │ patient_id (FK) │    │ patient_id (FK) │
│ birth_date      │    │ nurse_id (FK)   │    │ doctor_id (FK)  │
│ address         │    │ visit_date      │    │ diagnosis       │
│ phone           │    │ reason          │    │ treatment       │
│ email           │    │ observations    │    │ created_date    │
│ age             │    │                 │    │                 │
│ gender          │    │                 │    │                 │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │
         │              ┌─────────────────┐
         └──────────────│   INSURANCE     │
                        │                 │
                        │ id (PK)         │
                        │ patient_id (FK) │
                        │ policy_number   │
                        │ provider        │
                        │ is_active       │
                        │ annual_copay    │
                        └─────────────────┘
```

## 🎯 Entidades JPA Detalladas

### `PatientEntity` - Pacientes

```java
@Entity
@Table(name = "patient")
public class PatientEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // Clave primaria auto-incremental
    
    @Column(name = "full_name")
    private String fullName;            // Nombre completo del paciente
    
    @Column(name = "birth_date")
    private String birthDate;           // Fecha de nacimiento (String por simplicidad)
    
    @Column(name = "address")
    private String address;             // Dirección de residencia
    
    @Column(name = "phone")
    private String phone;               // Número de teléfono
    
    @Column(name = "email")
    private String email;               // Correo electrónico
    
    @Column(name = "age")
    private Integer age;                // Edad calculada
    
    @Column(name = "gender")
    private String gender;              // Género (almacenado como String)
}
```

**Características JPA:**
- **@Entity**: Marca la clase como entidad persistente
- **@Table**: Especifica nombre de tabla en BD
- **@Id + @GeneratedValue**: Clave primaria auto-generada
- **@Column**: Mapeo específico de columnas

### `UserEntity` - Usuarios del Sistema

```java
@Entity
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "username", unique = true)
    private String username;            // Usuario único para login
    
    @Column(name = "password")
    private String password;            // Contraseña (debería estar encriptada)
    
    @Column(name = "full_name")
    private String fullName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;                  // ADMIN, DOCTOR, NURSE, HR
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "is_active")
    private Boolean isActive = true;    // Estado del usuario
}
```

**Características Avanzadas:**
- **@Enumerated(EnumType.STRING)**: Persistir enums como texto
- **unique = true**: Constraint de unicidad a nivel JPA
- **Valores por defecto**: `isActive = true`

### `MedicalRecordEntity` - Historias Clínicas

```java
@Entity
@Table(name = "medical_record")
public class MedicalRecordEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "patient_id")
    private Long patientId;             // FK a Patient
    
    @Column(name = "doctor_id")
    private Long doctorId;              // FK a User (Doctor)
    
    @Column(name = "diagnosis", length = 1000)
    private String diagnosis;           // Diagnóstico médico
    
    @Column(name = "treatment", length = 2000)
    private String treatment;           // Tratamiento prescrito
    
    @Column(name = "observations", length = 3000)
    private String observations;        // Observaciones adicionales
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;           // Fecha de creación
}
```

**Características de Texto:**
- **length**: Especifica longitud máxima de campos texto
- **@Temporal**: Mapeo específico para fechas
- **TemporalType.TIMESTAMP**: Incluye fecha y hora

## 🔄 Mappers - Transformación de Datos

### Necesidad de Transformación

En arquitectura hexagonal, necesitamos **3 tipos de objetos**:

1. **Domain Models**: Objetos de negocio puros
2. **JPA Entities**: Objetos para persistencia
3. **DTOs**: Objetos para transferencia de datos

### `PatientMapper` - Ejemplo Detallado

```java
public class PatientMapper {
    
    // Transformación: Entity → Domain
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;
        
        Patient p = new Patient();
        if (entity.getId() != null) p.setId(entity.getId());
        p.setFullName(entity.getFullName());
        p.setBirthDate(entity.getBirthDate());
        p.setAddress(entity.getAddress());
        p.setPhone(entity.getPhone());
        p.setEmail(entity.getEmail());
        if (entity.getAge() != null) p.setAge(entity.getAge());
        
        // Conversión de enum con manejo de errores
        if (entity.getGender() != null) {
            try { 
                p.setGender(Gender.valueOf(entity.getGender())); 
            } catch (IllegalArgumentException ex) { 
                // Log error y continuar
            }
        }
        
        return p;
    }
    
    // Transformación: Domain → Entity
    public static PatientEntity toEntity(Patient p) {
        if (p == null) return null;
        
        PatientEntity e = new PatientEntity();
        if (p.getId() != 0) e.setId(p.getId());
        e.setFullName(p.getFullName());
        e.setBirthDate(p.getBirthDate());
        e.setAddress(p.getAddress());
        e.setPhone(p.getPhone());
        e.setEmail(p.getEmail());
        e.setAge(p.getAge());
        e.setGender(p.getGender() != null ? p.getGender().name() : null);
        
        return e;
    }
}
```

### Razones para Múltiples Representaciones

#### 1. **Separación de Responsabilidades**

**Domain Model (Patient.java)**:
```java
public class Patient extends Person {
    private EmergencyContact emergencyContact;  // Objeto complejo
    private Insurance insurance;                // Relación de negocio
    
    // Lógica de negocio
    public boolean hasActiveInsurance() {
        return insurance != null && insurance.isPolicyActive();
    }
}
```

**JPA Entity (PatientEntity.java)**:
```java
@Entity
public class PatientEntity {
    @Column(name = "emergency_contact_id")
    private Long emergencyContactId;    // Solo FK, no objeto completo
    
    @Column(name = "insurance_id")
    private Long insuranceId;           // Referencia simple
    
    // Sin lógica de negocio, solo persistencia
}
```

#### 2. **Optimización de Consultas**

```java
// Entity puede tener anotaciones específicas de JPA
@Entity
@NamedQuery(
    name = "PatientEntity.findByAge",
    query = "SELECT p FROM PatientEntity p WHERE p.age BETWEEN :minAge AND :maxAge"
)
public class PatientEntity {
    // Optimizada para consultas SQL
}
```

#### 3. **Evolución Independiente**

- **Dominio**: Cambia según reglas de negocio
- **Persistencia**: Cambia según optimizaciones de BD
- **API**: Cambia según necesidades de clientes

## 🗂️ Repositories JPA

### Interfaz Base

```java
@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    
    // Métodos automáticos de JpaRepository:
    // - save(entity)
    // - findById(id)
    // - findAll()
    // - delete(entity)
    // - count()
    
    // Consultas personalizadas
    List<PatientEntity> findByAgeGreaterThan(Integer age);
    
    @Query("SELECT p FROM PatientEntity p WHERE p.fullName LIKE %:name%")
    List<PatientEntity> findByNameContaining(@Param("name") String name);
    
    @Modifying
    @Query("UPDATE PatientEntity p SET p.isActive = false WHERE p.id = :id")
    void deactivatePatient(@Param("id") Long id);
}
```

### Consultas Derivadas Automáticas

Spring Data JPA genera automáticamente implementaciones:

```java
// Nombre del método → SQL generado
findByAge(Integer age)              → WHERE age = ?
findByAgeGreaterThan(Integer age)   → WHERE age > ?
findByFullNameAndAge()              → WHERE full_name = ? AND age = ?
findByAgeOrderByFullNameAsc()       → WHERE age = ? ORDER BY full_name ASC
countByAge(Integer age)             → SELECT COUNT(*) WHERE age = ?
deleteByAge(Integer age)            → DELETE WHERE age = ?
```

## 🔌 Adaptadores de Puerto

### Implementación de Puerto de Dominio

```java
@Component
public class PatientJpaAdapter implements PatientPort {
    
    private final PatientRepository repository;
    
    public PatientJpaAdapter(PatientRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void save(Patient patient) {
        PatientEntity entity = PatientMapper.toEntity(patient);
        repository.save(entity);
    }
    
    @Override
    public Patient findById(Long id) {
        Optional<PatientEntity> entity = repository.findById(id);
        return entity.map(PatientMapper::toDomain).orElse(null);
    }
    
    @Override
    public List<Patient> findAll() {
        return repository.findAll()
                .stream()
                .map(PatientMapper::toDomain)
                .collect(Collectors.toList());
    }
}
```

**Beneficios del Adaptador:**
- **Aislamiento**: Dominio no conoce JPA
- **Transformación**: Manejo automático de mapeo
- **Testing**: Fácil mock del puerto

## 🏗️ Configuración JPA

### `application.properties`

```properties
# Conexión a MySQL
spring.datasource.url=jdbc:mysql://localhost:3308/Clinica?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update       # Actualiza esquema automáticamente
spring.jpa.show-sql=true                   # Muestra SQL en logs
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true
```

### Estrategias de `ddl-auto`

- **`create`**: Borra y recrea tablas al iniciar
- **`create-drop`**: Crea al iniciar, borra al cerrar
- **`update`**: Actualiza esquema sin perder datos
- **`validate`**: Solo valida que esquema coincida
- **`none`**: No hace cambios automáticos

## 🧪 Testing de Persistencia

### Test de Repository

```java
@DataJpaTest
class PatientRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private PatientRepository repository;
    
    @Test
    void findByAge_ShouldReturnPatientsOfSpecificAge() {
        // Arrange
        PatientEntity patient = new PatientEntity();
        patient.setFullName("Juan Pérez");
        patient.setAge(25);
        entityManager.persistAndFlush(patient);
        
        // Act
        List<PatientEntity> result = repository.findByAge(25);
        
        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getFullName()).isEqualTo("Juan Pérez");
    }
}
```

### Test de Mapper

```java
@Test
void toDomain_ShouldMapEntityCorrectly() {
    // Arrange
    PatientEntity entity = new PatientEntity();
    entity.setId(1L);
    entity.setFullName("María García");
    entity.setAge(30);
    entity.setGender("FEMALE");
    
    // Act
    Patient domain = PatientMapper.toDomain(entity);
    
    // Assert
    assertThat(domain.getId()).isEqualTo(1L);
    assertThat(domain.getFullName()).isEqualTo("María García");
    assertThat(domain.getAge()).isEqualTo(30);
    assertThat(domain.getGender()).isEqualTo(Gender.FEMALE);
}
```

## 📈 Optimizaciones y Mejores Prácticas

### 1. **Lazy Loading**

```java
@Entity
public class PatientEntity {
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private List<MedicalRecordEntity> medicalRecords;
    
    // Solo se cargan cuando se acceden
}
```

### 2. **Índices de Base de Datos**

```java
@Entity
@Table(name = "patient", indexes = {
    @Index(name = "idx_patient_age", columnList = "age"),
    @Index(name = "idx_patient_email", columnList = "email", unique = true)
})
public class PatientEntity {
    // Consultas optimizadas por edad y email
}
```

### 3. **Auditoría Automática**

```java
@Entity
@EntityListeners(AuditingEntityListener.class)
public class PatientEntity {
    
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    
    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
```

### 4. **Paginación**

```java
@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    
    Page<PatientEntity> findByAgeGreaterThan(Integer age, Pageable pageable);
}

// Uso:
Pageable pageable = PageRequest.of(0, 10, Sort.by("fullName"));
Page<PatientEntity> patients = repository.findByAgeGreaterThan(18, pageable);
```

## 🚀 Migración y Evolución

### Scripts de Migración

Para cambios complejos de esquema, usar Flyway o Liquibase:

```sql
-- V2__add_patient_insurance.sql
ALTER TABLE patient 
ADD COLUMN insurance_id BIGINT,
ADD FOREIGN KEY (insurance_id) REFERENCES insurance(id);
```

### Versionado de Entidades

```java
@Entity
@Table(name = "patient")
public class PatientEntity {
    
    @Version
    private Long version;    // Control de concurrencia optimista
    
    // Hibernate maneja automáticamente conflictos de escritura
}
```

---

Esta estructura de persistencia garantiza que el dominio permanezca independiente de los detalles de base de datos, mientras proporciona un mapeo robusto y eficiente entre el mundo de objetos y el mundo relacional.
