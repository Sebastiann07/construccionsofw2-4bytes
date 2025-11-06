# 🌐 API REST - Documentación Completa de Endpoints

## Visión General

La API REST implementa endpoints organizados por roles de usuario, siguiendo los principios de **Arquitectura Hexagonal**. Cada rol tiene su propio controlador con endpoints específicos para sus responsabilidades en el sistema clínico.

## 🎯 Estructura de la API

```
/api/
├── admin/              # Gestión administrativa
├── doctor/             # Funciones médicas
├── nurse/              # Cuidados de enfermería
└── hr/                 # Recursos humanos
```

## 👨‍💼 Admin API - `/api/admin`

### Gestión de Pacientes

#### `POST /api/admin/patients` - Crear Paciente

**Request:**
```json
{
  "patient": {
    "fullName": "Juan Carlos Pérez",
    "age": 35,
    "gender": "MALE",
    "birthDate": "1988-05-15",
    "address": "Calle 123 #45-67",
    "phone": "+573001234567",
    "email": "juan.perez@email.com"
  }
}
```

**Response:**
```json
{
  "message": "Paciente creado",
  "patient": {
    "id": 1,
    "fullName": "Juan Carlos Pérez",
    "age": 35,
    "gender": "MALE",
    "birthDate": "1988-05-15",
    "address": "Calle 123 #45-67",
    "phone": "+573001234567",
    "email": "juan.perez@email.com"
  }
}
```

**Códigos de Estado:**
- `200 OK` - Paciente creado exitosamente
- `400 Bad Request` - Datos inválidos
- `409 Conflict` - Paciente ya existe

#### `PUT /api/admin/patients` - Actualizar Paciente

**Request:**
```json
{
  "patient": {
    "id": 1,
    "fullName": "Juan Carlos Pérez González",
    "age": 36,
    "address": "Nueva Calle 456 #78-90",
    "phone": "+573009876543"
  }
}
```

### Facturación

#### `POST /api/admin/invoices` - Crear Factura

**Request:**
```json
{
  "invoice": {
    "invoiceNumber": "INV-2024-001",
    "patientId": 1,
    "doctorId": 2,
    "totalAmount": 150000.0,
    "copay": 15000.0,
    "insurerCharge": 135000.0,
    "details": [
      {
        "name": "Consulta médica general",
        "cost": 80000.0,
        "diagnosticType": "EXAM"
      },
      {
        "name": "Acetaminofén 500mg",
        "cost": 25000.0,
        "dose": "1 tableta cada 8 horas",
        "diagnosticType": "MEDICATION"
      }
    ]
  }
}
```

### Seguros y Contactos

#### `POST /api/admin/insurances` - Crear Seguro

**Request:**
```json
{
  "insurance": {
    "patientId": 1,
    "policyNumber": "POL-12345678",
    "provider": "EPS Salud Total",
    "isPolicyActive": true,
    "copayPercentage": 10.0,
    "annualCopayTotal": 250000.0
  }
}
```

#### `POST /api/admin/emergency-contacts` - Crear Contacto de Emergencia

**Request:**
```json
{
  "contact": {
    "patientId": 1,
    "name": "María Pérez",
    "phone": "+573002468013",
    "relationship": "Esposa",
    "address": "Calle 123 #45-67"
  }
}
```

### Programación de Visitas

#### `POST /api/admin/visits` - Programar Visita

**Request:**
```json
{
  "visit": {
    "patientId": 1,
    "nurseId": 3,
    "visitDate": "2024-11-15T10:30:00",
    "reason": "Control de signos vitales",
    "status": "SCHEDULED"
  }
}
```

### Gestión de Usuarios

#### `PUT /api/admin/users` - Actualizar Usuario

**Request:**
```json
{
  "user": {
    "id": 2,
    "fullName": "Dr. Ana García Rodríguez",
    "email": "ana.garcia@hospital.com",
    "role": "DOCTOR",
    "isActive": true
  }
}
```

## 👨‍⚕️ Doctor API - `/api/doctor`

### Historias Clínicas

#### `POST /api/doctor/medical-records` - Crear Historia Clínica

**Request:**
```json
{
  "record": {
    "patientId": 1,
    "doctorId": 2,
    "diagnosis": "Hipertensión arterial leve",
    "treatment": "Dieta baja en sodio, ejercicio regular, medicamento antihipertensivo",
    "observations": "Paciente refiere dolores de cabeza matutinos. Antecedentes familiares de HTA.",
    "createdDate": "2024-11-06T14:30:00"
  }
}
```

**Response:**
```json
{
  "message": "Historia clínica creada",
  "record": {
    "id": 1,
    "patientId": 1,
    "doctorId": 2,
    "diagnosis": "Hipertensión arterial leve",
    "treatment": "Dieta baja en sodio, ejercicio regular, medicamento antihipertensivo",
    "observations": "Paciente refiere dolores de cabeza matutinos. Antecedentes familiares de HTA.",
    "createdDate": "2024-11-06T14:30:00"
  }
}
```

#### `PUT /api/doctor/medical-records` - Actualizar Historia Clínica

**Request:**
```json
{
  "record": {
    "id": 1,
    "diagnosis": "Hipertensión arterial leve controlada",
    "treatment": "Continuar con medicamento. Reducir dosis gradualmente.",
    "observations": "Mejoría notable en presión arterial. Paciente cumple tratamiento."
  }
}
```

### Órdenes Médicas

#### `POST /api/doctor/medical-orders` - Crear Orden Médica

**Request:**
```json
{
  "order": {
    "patientId": 1,
    "doctorId": 2,
    "orderDate": "2024-11-06T15:00:00",
    "instructions": "Administrar medicamentos según prescripción. Tomar signos vitales cada 4 horas.",
    "status": "ACTIVE",
    "items": [
      {
        "type": "MEDICATION",
        "name": "Losartán 50mg",
        "dosage": "1 tableta cada 12 horas",
        "duration": "30 días"
      },
      {
        "type": "PROCEDURE",
        "name": "Control de presión arterial",
        "frequency": "Cada 4 horas",
        "duration": "Durante hospitalización"
      }
    ]
  }
}
```

### Prescripciones

#### `POST /api/doctor/medicines` - Prescribir Medicina

**Request:**
```json
{
  "medicine": {
    "name": "Losartán",
    "dosage": "50mg",
    "frequency": "Cada 12 horas",
    "duration": "30 días",
    "instructions": "Tomar con alimentos. No suspender abruptamente.",
    "patientId": 1,
    "doctorId": 2,
    "prescriptionDate": "2024-11-06T15:30:00"
  }
}
```

#### `POST /api/doctor/procedures` - Prescribir Procedimiento

**Request:**
```json
{
  "procedure": {
    "name": "Electrocardiograma",
    "description": "ECG de 12 derivaciones para evaluación cardiológica",
    "estimatedDuration": "15 minutos",
    "specialInstructions": "Paciente en ayunas. Evitar cafeína 24h antes.",
    "patientId": 1,
    "doctorId": 2,
    "scheduledDate": "2024-11-08T09:00:00"
  }
}
```

### Ayudas Diagnósticas

#### `POST /api/doctor/diagnostic-helps` - Crear Ayuda Diagnóstica

**Request:**
```json
{
  "diagnosticHelp": {
    "patientId": 1,
    "doctorId": 2,
    "type": "LABORATORY",
    "name": "Perfil lipídico completo",
    "description": "Análisis de colesterol total, HDL, LDL y triglicéridos",
    "instructions": "Ayuno de 12 horas. Suspender medicamentos lipídicos 48h antes.",
    "urgency": "ROUTINE",
    "requestDate": "2024-11-06T16:00:00",
    "expectedDate": "2024-11-07T08:00:00"
  }
}
```

## 👩‍⚕️ Nurse API - `/api/nurse`

### Signos Vitales

#### `POST /api/nurse/vital-signs` - Registrar Signos Vitales

**Request:**
```json
{
  "patientId": 1,
  "vitalSigns": {
    "bloodPressureSystolic": 135,
    "bloodPressureDiastolic": 85,
    "heartRate": 78,
    "respiratoryRate": 16,
    "temperature": 36.8,
    "oxygenSaturation": 98,
    "weight": 75.5,
    "height": 175,
    "measurementDate": "2024-11-06T08:30:00",
    "notes": "Paciente estable. Presión ligeramente elevada."
  }
}
```

**Response:**
```json
{
  "message": "Signos vitales registrados",
  "vitalSigns": {
    "id": 1,
    "patientId": 1,
    "bloodPressureSystolic": 135,
    "bloodPressureDiastolic": 85,
    "heartRate": 78,
    "respiratoryRate": 16,
    "temperature": 36.8,
    "oxygenSaturation": 98,
    "weight": 75.5,
    "height": 175,
    "measurementDate": "2024-11-06T08:30:00",
    "notes": "Paciente estable. Presión ligeramente elevada."
  }
}
```

### Administración de Medicamentos

#### `POST /api/nurse/order-items/{id}/administer` - Administrar Ítem de Orden

**Path Parameter:**
- `id` - ID del ítem de orden médica

**Request:**
```json
{
  "notes": "Medicamento administrado según prescripción. Paciente tolera bien. Sin efectos adversos observados."
}
```

**Response:**
```json
{
  "message": "Ítem administrado",
  "orderItemId": "ORD-001-MED-001"
}
```

**Reglas de Negocio:**
- Solo enfermeras pueden administrar medicamentos
- El ítem debe estar en estado `PENDING`
- Se requieren observaciones de la administración
- Estado cambia automáticamente a `ADMINISTERED`

### Pruebas Diagnósticas

#### `POST /api/nurse/diagnostic-helps` - Registrar Ayuda Diagnóstica

**Request:**
```json
{
  "diagnosticHelp": {
    "patientId": 1,
    "nurseId": 3,
    "type": "NURSING_ASSESSMENT",
    "name": "Evaluación de herida quirúrgica",
    "description": "Inspección y curación de herida postoperatoria",
    "findings": "Herida limpia, sin signos de infección. Bordes bien aproximados.",
    "recommendations": "Continuar curaciones cada 24h. Mantener zona seca.",
    "performedDate": "2024-11-06T10:15:00"
  }
}
```

### Observaciones Médicas

#### `PUT /api/nurse/medical-records` - Añadir Observación a Historia

**Request:**
```json
{
  "record": {
    "id": 1,
    "nurseObservations": "Paciente presenta mejoría en signos vitales. Cooperativo con tratamiento. Refiere disminución de cefalea. Tolerancia oral adecuada.",
    "lastUpdateDate": "2024-11-06T11:45:00",
    "lastUpdatedBy": "Enfermera María González"
  }
}
```

## 👥 HR API - `/api/hr`

### Gestión de Usuarios

#### `POST /api/hr/users` - Crear Usuario

**Request:**
```json
{
  "user": {
    "username": "dr.rodriguez",
    "password": "SecurePass123!",
    "fullName": "Dr. Carlos Rodríguez Mendoza",
    "email": "carlos.rodriguez@hospital.com",
    "role": "DOCTOR",
    "specialization": "Cardiología",
    "licenseNumber": "MED-12345678",
    "isActive": true
  }
}
```

**Response:**
```json
{
  "message": "Usuario creado",
  "user": {
    "id": 4,
    "username": "dr.rodriguez",
    "fullName": "Dr. Carlos Rodríguez Mendoza",
    "email": "carlos.rodriguez@hospital.com",
    "role": "DOCTOR",
    "specialization": "Cardiología",
    "licenseNumber": "MED-12345678",
    "isActive": true,
    "createdDate": "2024-11-06T12:00:00"
  }
}
```

#### `PUT /api/hr/users` - Actualizar Usuario

**Request:**
```json
{
  "user": {
    "id": 4,
    "fullName": "Dr. Carlos Rodríguez Mendoza",
    "email": "c.rodriguez@hospital.com",
    "specialization": "Cardiología Intervencionista",
    "isActive": true
  }
}
```

#### `DELETE /api/hr/users/{id}` - Eliminar Usuario

**Path Parameter:**
- `id` - ID del usuario a eliminar

**Response:**
```json
{
  "message": "Usuario eliminado",
  "userId": 4
}
```

**Reglas de Negocio:**
- Solo usuarios inactivos pueden eliminarse
- Se debe verificar que no tenga pacientes asignados
- Eliminación lógica (soft delete) recomendada

## 🔒 Códigos de Estado HTTP

### Exitosos (2xx)
- `200 OK` - Operación exitosa
- `201 Created` - Recurso creado exitosamente

### Errores del Cliente (4xx)
- `400 Bad Request` - Datos inválidos en la petición
- `401 Unauthorized` - Autenticación requerida
- `403 Forbidden` - Permisos insuficientes para el rol
- `404 Not Found` - Recurso no encontrado
- `409 Conflict` - Conflicto con estado actual (ej: duplicados)
- `422 Unprocessable Entity` - Datos válidos pero lógica de negocio fallida

### Errores del Servidor (5xx)
- `500 Internal Server Error` - Error interno del servidor
- `503 Service Unavailable` - Servicio temporalmente no disponible

## 🛡️ Seguridad y Validaciones

### Validaciones por Campo

```json
{
  "fullName": {
    "required": true,
    "minLength": 2,
    "maxLength": 100,
    "pattern": "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"
  },
  "email": {
    "required": true,
    "format": "email",
    "maxLength": 150
  },
  "phone": {
    "required": false,
    "pattern": "^\\+57[0-9]{10}$"
  },
  "age": {
    "required": true,
    "minimum": 0,
    "maximum": 150
  }
}
```

### Headers Requeridos

```http
Content-Type: application/json
Accept: application/json
Authorization: Bearer <token>  # Cuando se implemente autenticación
X-Request-ID: <uuid>          # Para trazabilidad
```

## 📊 Monitoreo y Logging

### Métricas Importantes
- **Tiempo de respuesta** por endpoint
- **Tasa de éxito/error** por operación
- **Volumen de peticiones** por rol
- **Errores de validación** más frecuentes

### Logs de Auditoría
```json
{
  "timestamp": "2024-11-06T15:30:00Z",
  "endpoint": "/api/admin/patients",
  "method": "POST",
  "userId": "admin123",
  "role": "ADMIN",
  "action": "CREATE_PATIENT",
  "resourceId": "patient:1",
  "status": "SUCCESS",
  "duration": "150ms"
}
```

## 🧪 Testing de API

### Ejemplo con curl

```bash
# Crear paciente
curl -X POST http://localhost:8081/api/admin/patients \
  -H "Content-Type: application/json" \
  -d '{
    "patient": {
      "fullName": "Juan Pérez",
      "age": 35,
      "gender": "MALE",
      "phone": "+573001234567",
      "email": "juan@email.com"
    }
  }'

# Registrar signos vitales
curl -X POST http://localhost:8081/api/nurse/vital-signs \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": 1,
    "vitalSigns": {
      "bloodPressureSystolic": 120,
      "bloodPressureDiastolic": 80,
      "heartRate": 72,
      "temperature": 36.5
    }
  }'
```

### Testing con Postman

Importar colección con todos los endpoints:
```json
{
  "info": {
    "name": "Sistema Clínico API",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/"
  },
  "item": [
    {
      "name": "Admin",
      "item": [
        {
          "name": "Crear Paciente",
          "request": {
            "method": "POST",
            "url": "{{baseUrl}}/api/admin/patients",
            "body": "..."
          }
        }
      ]
    }
  ]
}
```

---

Esta API proporciona una interfaz completa y bien estructurada para todas las operaciones del sistema clínico, manteniendo la separación clara de responsabilidades por rol y siguiendo las mejores prácticas de diseño REST.
