# 🏥 Sistema de Gestión Clínica - Arquitectura Hexagonal

Sistema integral de gestión clínica desarrollado con **Spring Boot** siguiendo los principios de **Arquitectura Hexagonal (Ports & Adapters)** y **Domain-Driven Design (DDD)**.

## 📋 Tabla de Contenidos

- [Integrantes](#integrantes)
- [Tecnologías](#tecnologías)
- [Arquitectura del Sistema](#arquitectura-del-sistema)
- [Documentación Detallada](#documentación-detallada)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [API Endpoints](#api-endpoints)
- [Estructura del Proyecto](#estructura-del-proyecto)

## 👥 Integrantes

- **Sebastián David Sánchez Parra**
- **Miguel Angel Quintero Jaramillo**

## 🛠️ Tecnologías

- **Backend**: Java 17 + Spring Boot 3.x
- **Base de Datos**: MySQL 8.0
- **ORM**: Spring Data JPA + Hibernate
- **Documentación**: Markdown
- **Arquitectura**: Hexagonal (Ports & Adapters)
- **Patrones**: DDD, CQRS, Repository Pattern

## 🏗️ Arquitectura del Sistema

El sistema implementa **Arquitectura Hexagonal** con las siguientes capas:

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Adapters IN   │    │     Domain      │    │  Adapters OUT   │
│   (REST APIs)   │────│   (Business)    │────│ (Persistence)   │
│                 │    │                 │    │                 │
│ - Controllers   │    │ - Models        │    │ - JPA Entities  │
│ - DTOs          │    │ - Services      │    │ - Repositories  │
│ - Mappers       │    │ - Ports         │    │ - Mappers       │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

### 🎯 Roles del Sistema

- **👨‍💼 Admin**: Gestión de pacientes, facturación, seguros
- **👨‍⚕️ Doctor**: Historias clínicas, órdenes médicas, diagnósticos
- **👩‍⚕️ Nurse**: Signos vitales, administración de medicamentos
- **👥 HR**: Gestión de usuarios del sistema

## 📚 Documentación Detallada

| Documento | Descripción |
|-----------|-------------|
| [🏛️ Arquitectura](docs/ARCHITECTURE.md) | Explicación detallada de la arquitectura hexagonal |
| [🏢 Dominio y Servicios](docs/DOMAIN.md) | Reglas de negocio y servicios de dominio |
| [🗄️ Persistencia y JPA](docs/PERSISTENCE.md) | Entities, repositories y mapeo objeto-relacional |
| [🔄 Transformación de DTOs](docs/DTOS.md) | Estrategias de mapeo entre capas |
| [🌐 API REST](docs/API.md) | Documentación completa de endpoints |
| [⚙️ Configuración](docs/SETUP.md) | Guía de instalación y configuración |

## 🚀 Instalación y Ejecución

### Prerrequisitos
- Java 17+
- MySQL 8.0
- Maven 3.6+

### Pasos de Instalación

1. **Clonar el repositorio**
```bash
git clone <repository-url>
cd construccionsofw2-4bytes/trabajo
```

2. **Configurar base de datos**
```sql
CREATE DATABASE Clinica;
```

3. **Configurar application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3308/Clinica
spring.datasource.username=root
spring.datasource.password=
```

4. **Ejecutar la aplicación**
```bash
./mvnw spring-boot:run
```

5. **Verificar funcionamiento**
- Servidor: http://localhost:8081
- Los endpoints disponibles se mostrarán en el log de inicio

## 🌐 API Endpoints

### 👨‍💼 Admin (`/api/admin`)
- `POST /patients` - Crear paciente
- `PUT /patients` - Actualizar paciente
- `POST /invoices` - Crear factura
- `POST /emergency-contacts` - Crear contacto de emergencia
- `POST /insurances` - Crear seguro
- `POST /visits` - Programar visita
- `PUT /users` - Actualizar usuario

### 👨‍⚕️ Doctor (`/api/doctor`)
- `POST /medical-records` - Crear historia clínica
- `PUT /medical-records` - Actualizar historia clínica
- `POST /medical-orders` - Crear orden médica
- `POST /medicines` - Prescribir medicina
- `POST /procedures` - Prescribir procedimiento
- `POST /diagnostic-helps` - Crear ayuda diagnóstica

### 👩‍⚕️ Nurse (`/api/nurse`)
- `POST /vital-signs` - Registrar signos vitales
- `POST /order-items/{id}/administer` - Administrar ítem de orden
- `POST /diagnostic-helps` - Registrar ayuda diagnóstica
- `PUT /medical-records` - Añadir observación a historia

### 👥 HR (`/api/hr`)
- `POST /users` - Crear usuario
- `PUT /users` - Actualizar usuario
- `DELETE /users/{id}` - Eliminar usuario

## 📁 Estructura del Proyecto

```
src/main/java/app/
├── adapter/in/                 # Adaptadores de entrada
├── application/usecases/       # Casos de uso por rol
├── domain/                     # Núcleo del negocio
│   ├── model/                  # Modelos de dominio
│   ├── ports/                  # Interfaces (puertos)
│   └── services/               # Servicios de dominio
├── infrastructure/             # Infraestructura
│   ├── adapter/in/rest/        # Controllers REST
│   ├── config/                 # Configuraciones
│   └── persistence/            # Persistencia JPA
└── TrabajoApplication.java     # Clase principal
```

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

---

**🏥 Sistema de Gestión Clínica** - Desarrollado con ❤️ usando Spring Boot y Arquitectura Hexagonal
