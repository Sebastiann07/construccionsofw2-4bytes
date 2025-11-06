# 🏛️ Arquitectura del Sistema

## Visión General

El sistema implementa **Arquitectura Hexagonal** (también conocida como Ports & Adapters), un patrón arquitectónico que promueve el aislamiento del núcleo de negocio de los detalles técnicos externos.

## 🎯 Principios Fundamentales

### 1. Separación de Responsabilidades
- **Núcleo de Negocio**: Contiene la lógica empresarial pura
- **Adaptadores**: Manejan la comunicación con el mundo exterior
- **Puertos**: Definen contratos entre el núcleo y los adaptadores

### 2. Inversión de Dependencias
```java
// El dominio define el puerto
public interface PatientPort {
    void save(Patient patient);
    Optional<Patient> findById(Long id);
}

// La infraestructura implementa el puerto
@Repository
public class PatientJpaAdapter implements PatientPort {
    // Implementación específica de JPA
}
```

### 3. Independencia Tecnológica
- El núcleo no depende de frameworks
- Fácil cambio de tecnologías (base de datos, API, etc.)
- Testing simplificado mediante mocks

## 📁 Estructura de Capas

### 🔵 Capa de Dominio (Centro del Hexágono)

```
domain/
├── model/              # Entidades de negocio
│   ├── Patient.java
│   ├── MedicalRecord.java
│   ├── User.java
│   └── ...
├── ports/              # Interfaces (contratos)
│   ├── PatientPort.java
│   ├── UserPort.java
│   └── ...
└── services/           # Servicios de dominio
    ├── CreatePatient.java
    ├── UpdatePatient.java
    └── ...
```

**Características:**
- Sin dependencias externas
- Lógica de negocio pura
- Inmutable ante cambios tecnológicos

### 🟢 Capa de Aplicación

```
application/usecases/
├── AdminUseCase.java       # Orquestación para Admin
├── DoctorUseCase.java      # Orquestación para Doctor
├── NurseUseCase.java       # Orquestación para Nurse
└── HumanResourcesUseCase.java
```

**Responsabilidades:**
- Orquestar servicios de dominio
- Coordinar flujos de trabajo
- Aplicar casos de uso específicos

### 🔴 Adaptadores de Entrada (Input Adapters)

```
infrastructure/adapter/in/rest/
├── admin/
│   ├── AdminController.java
│   ├── AdminMapper.java
│   └── DTOs (Request/Response)
├── doctor/
├── nurse/
└── humanresources/
```

**Función:**
- Recibir peticiones externas (HTTP REST)
- Transformar DTOs a modelos de dominio
- Invocar casos de uso

### 🟡 Adaptadores de Salida (Output Adapters)

```
infrastructure/persistence/
├── entities/           # Entidades JPA
├── repositories/       # Implementaciones JPA
└── mappers/           # Transformación Domain ↔ JPA
```

**Función:**
- Persistir datos en base de datos
- Implementar puertos de salida
- Manejar detalles de persistencia

## 🔄 Flujo de Datos

### 1. Petición Entrante
```
HTTP Request → Controller → Mapper → UseCase → DomainService → Port → Repository → Database
```

### 2. Respuesta Saliente
```
Database → Repository → Port → DomainService → UseCase → Mapper → Controller → HTTP Response
```

### 3. Ejemplo Completo: Crear Paciente

```java
// 1. Controller recibe petición
@PostMapping("/patients")
public ResponseEntity<CreatePatientResponse> createPatient(@RequestBody CreatePatientRequest request) {
    // 2. Mapper convierte DTO a modelo de dominio
    Patient patient = mapper.toPatient(request);
    
    // 3. UseCase orquesta la operación
    adminUseCase.createPatient(patient);
    
    // 4. Respuesta al cliente
    return ResponseEntity.ok(new CreatePatientResponse("Paciente creado", patient));
}

// 5. UseCase delega al servicio de dominio
public void createPatient(Patient patient) throws Exception {
    createPatient.createPatient(patient);
}

// 6. Servicio de dominio aplica reglas de negocio
public void createPatient(Patient patient) throws Exception {
    // Validaciones de negocio
    if (patient.getAge() < 0) {
        throw new IllegalArgumentException("La edad no puede ser negativa");
    }
    
    // 7. Usa puerto para persistir
    patientPort.save(patient);
}

// 8. Adaptador JPA implementa la persistencia
@Override
public void save(Patient patient) {
    PatientEntity entity = patientMapper.toEntity(patient);
    jpaRepository.save(entity);
}
```

## 🎨 Beneficios de la Arquitectura

### ✅ Ventajas

1. **Testabilidad**: Fácil testing con mocks
2. **Mantenibilidad**: Cambios aislados por capa
3. **Flexibilidad**: Fácil cambio de tecnologías
4. **Reutilización**: Núcleo independiente del delivery
5. **Claridad**: Separación clara de responsabilidades

### ⚠️ Consideraciones

1. **Complejidad Inicial**: Más archivos y abstracciones
2. **Overhead**: Múltiples capas de mapeo
3. **Curva de Aprendizaje**: Requiere comprensión del patrón

## 🔧 Configuración de Inversión de Dependencias

```java
@Configuration
public class ApplicationConfig {
    
    @Bean
    public CreatePatient createPatient(PatientPort patientPort) {
        return new CreatePatient(patientPort);
    }
    
    @Bean
    public AdminUseCase adminUseCase(CreatePatient createPatient, /* otros servicios */) {
        return new AdminUseCase(createPatient, /* otros servicios */);
    }
}
```

Spring Boot maneja automáticamente la inyección de dependencias, conectando:
- Servicios de dominio con puertos (interfaces)
- Puertos con implementaciones (adaptadores)
- UseCase con servicios de dominio

## 📊 Métricas de Calidad

- **Acoplamiento**: Bajo entre capas
- **Cohesión**: Alta dentro de cada capa
- **Complejidad Ciclomática**: Reducida por separación
- **Cobertura de Testing**: Facilitada por inversión de dependencias

---

Esta arquitectura garantiza un sistema mantenible, testeable y evolutivo, donde los cambios tecnológicos no afectan la lógica de negocio central.
