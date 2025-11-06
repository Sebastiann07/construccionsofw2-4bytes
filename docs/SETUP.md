# ⚙️ Configuración e Instalación

## Prerrequisitos del Sistema

### Software Requerido

| Componente | Versión Mínima | Versión Recomendada | Notas |
|------------|----------------|---------------------|-------|
| **Java** | 17 | 21 LTS | OpenJDK o Oracle JDK |
| **MySQL** | 8.0 | 8.0.35+ | Para base de datos principal |
| **Maven** | 3.6.0 | 3.9.5+ | Gestión de dependencias |
| **Git** | 2.30+ | Latest | Control de versiones |

### Verificación de Prerrequisitos

```bash
# Verificar Java
java -version
# Esperado: openjdk version "17.0.x" o superior

# Verificar Maven
mvn -version
# Esperado: Apache Maven 3.6.x o superior

# Verificar MySQL
mysql --version
# Esperado: mysql Ver 8.0.x o superior

# Verificar Git
git --version
# Esperado: git version 2.30.x o superior
```

## 🗄️ Configuración de Base de Datos

### 1. Instalación de MySQL

#### Windows
```bash
# Descargar desde https://dev.mysql.com/downloads/installer/
# Ejecutar MySQL Installer
# Configurar puerto 3308 (o 3306 por defecto)
```

#### Linux (Ubuntu/Debian)
```bash
sudo apt update
sudo apt install mysql-server
sudo mysql_secure_installation
```

#### macOS
```bash
# Con Homebrew
brew install mysql
brew services start mysql
```

### 2. Configuración Inicial de MySQL

```sql
-- Conectar como root
mysql -u root -p

-- Crear base de datos
CREATE DATABASE Clinica CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Crear usuario específico (opcional)
CREATE USER 'clinica_user'@'localhost' IDENTIFIED BY 'secure_password';
GRANT ALL PRIVILEGES ON Clinica.* TO 'clinica_user'@'localhost';
FLUSH PRIVILEGES;

-- Verificar creación
SHOW DATABASES;
USE Clinica;
```

### 3. Configuración de Puerto Personalizado

Si usas puerto 3308 (como en el proyecto):

```sql
-- Editar archivo de configuración MySQL
# Windows: C:\ProgramData\MySQL\MySQL Server 8.0\my.ini
# Linux: /etc/mysql/mysql.conf.d/mysqld.cnf
# macOS: /usr/local/etc/my.cnf

[mysqld]
port = 3308

-- Reiniciar servicio MySQL
# Windows: Servicios > MySQL80 > Reiniciar
# Linux: sudo systemctl restart mysql
# macOS: brew services restart mysql
```

## 🚀 Instalación del Proyecto

### 1. Clonación del Repositorio

```bash
# Clonar repositorio
git clone <repository-url>
cd construccionsofw2-4bytes

# Verificar estructura
ls -la
# Esperado: LICENSE, README.md, trabajo/, docs/
```

### 2. Configuración de Propiedades

#### Archivo `application.properties`

```properties
# === CONFIGURACIÓN DE BASE DE DATOS ===
spring.datasource.url=jdbc:mysql://localhost:3308/Clinica?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# === CONFIGURACIÓN JPA/HIBERNATE ===
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true

# === CONFIGURACIÓN DE LOGGING ===
logging.level.app.infrastructure.config.EndpointLogger=INFO
logging.level.org.springframework.web=INFO
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n

# === CONFIGURACIÓN DEL SERVIDOR ===
server.port=8081
```

#### Configuraciones por Ambiente

**application-dev.properties** (Desarrollo):
```properties
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
logging.level.root=DEBUG
```

**application-prod.properties** (Producción):
```properties
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
logging.level.root=WARN
spring.datasource.password=${DB_PASSWORD}
```

**application-test.properties** (Testing):
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create-drop
```

### 3. Compilación del Proyecto

```bash
# Navegar al directorio del proyecto
cd trabajo

# Limpiar y compilar
./mvnw clean compile

# Ejecutar tests
./mvnw test

# Empaquetar aplicación
./mvnw package
```

### 4. Primera Ejecución

```bash
# Ejecutar aplicación
./mvnw spring-boot:run

# O ejecutar JAR compilado
java -jar target/trabajo-0.0.1-SNAPSHOT.jar
```

**Verificación de Inicio Exitoso:**
```
================================================================================
                    APLICACIÓN INICIADA - ENDPOINTS DISPONIBLES                 
================================================================================

🔧 ROLE: ADMIN - Base URL: /api/admin
   POST   /api/admin/patients              - Crear paciente
   PUT    /api/admin/patients              - Actualizar paciente
   ...

🚀 Servidor corriendo en: http://localhost:8081
📊 Base de datos: MySQL en localhost:3308/Clinica
================================================================================
```

## 🔧 Configuraciones Avanzadas

### 1. Pool de Conexiones

```properties
# HikariCP (por defecto en Spring Boot)
spring.datasource.hikari.maximum-pool-size=20
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.idle-timeout=300000
spring.datasource.hikari.max-lifetime=1200000
spring.datasource.hikari.connection-timeout=20000
```

### 2. Configuración de Actuator

```properties
# Agregar a pom.xml
# <dependency>
#   <groupId>org.springframework.boot</groupId>
#   <artifactId>spring-boot-starter-actuator</artifactId>
# </dependency>

management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=when-authorized
management.info.env.enabled=true
```

### 3. Perfiles de Spring

```bash
# Ejecutar con perfil específico
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# O con variable de entorno
export SPRING_PROFILES_ACTIVE=prod
./mvnw spring-boot:run
```

## 🐳 Configuración con Docker

### 1. Dockerfile

```dockerfile
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/trabajo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
```

### 2. Docker Compose

```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword
      MYSQL_DATABASE: Clinica
    ports:
      - "3308:3306"
    volumes:
      - mysql_data:/var/lib/mysql

  app:
    build: .
    ports:
      - "8081:8081"
    depends_on:
      - mysql
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/Clinica
      SPRING_DATASOURCE_PASSWORD: rootpassword

volumes:
  mysql_data:
```

```bash
# Ejecutar con Docker Compose
docker-compose up -d
```

## 🧪 Configuración de Testing

### 1. Base de Datos en Memoria para Tests

```xml
<!-- Agregar a pom.xml -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>test</scope>
</dependency>
```

### 2. TestContainers para Tests de Integración

```xml
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>mysql</artifactId>
    <scope>test</scope>
</dependency>
```

```java
@Testcontainers
class IntegrationTest {
    
    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");
    
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }
}
```

## 🔍 Troubleshooting

### Problemas Comunes

#### 1. Error de Conexión a MySQL

**Error:**
```
Cannot create PoolableConnectionFactory (Access denied for user 'root'@'localhost')
```

**Solución:**
```bash
# Verificar credenciales
mysql -u root -p

# Resetear contraseña si es necesario
sudo mysql
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'new_password';
FLUSH PRIVILEGES;
```

#### 2. Puerto 8081 en Uso

**Error:**
```
Web server failed to start. Port 8081 was already in use.
```

**Solución:**
```bash
# Encontrar proceso usando el puerto
netstat -ano | findstr :8081    # Windows
lsof -i :8081                   # Linux/macOS

# Cambiar puerto en application.properties
server.port=8082
```

#### 3. Error de Versión de Java

**Error:**
```
UnsupportedClassVersionError: app/TrabajoApplication has been compiled by a more recent version of the Java Runtime
```

**Solución:**
```bash
# Verificar versión de Java
java -version

# Instalar Java 17 o superior
# Windows: https://adoptium.net/
# Linux: sudo apt install openjdk-17-jdk
# macOS: brew install openjdk@17
```

#### 4. Maven Wrapper No Ejecutable

**Error:**
```
Permission denied: ./mvnw
```

**Solución:**
```bash
# Dar permisos de ejecución
chmod +x mvnw

# O usar Maven directamente
mvn spring-boot:run
```

### Logs de Depuración

```properties
# Habilitar logs detallados para depuración
logging.level.org.springframework=DEBUG
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

## 📊 Monitoreo y Salud

### 1. Health Checks

```bash
# Verificar salud de la aplicación
curl http://localhost:8081/actuator/health

# Respuesta esperada:
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "MySQL",
        "validationQuery": "isValid()"
      }
    }
  }
}
```

### 2. Métricas

```bash
# Ver métricas de la aplicación
curl http://localhost:8081/actuator/metrics

# Métricas específicas
curl http://localhost:8081/actuator/metrics/jvm.memory.used
curl http://localhost:8081/actuator/metrics/http.server.requests
```

## 🚀 Deployment

### 1. Construcción para Producción

```bash
# Compilar con perfil de producción
./mvnw clean package -Pprod

# Verificar JAR generado
ls -la target/trabajo-0.0.1-SNAPSHOT.jar
```

### 2. Variables de Entorno

```bash
# Script de deployment
export SPRING_PROFILES_ACTIVE=prod
export DB_HOST=prod-mysql-server
export DB_PASSWORD=secure_prod_password
export SERVER_PORT=8080

java -jar target/trabajo-0.0.1-SNAPSHOT.jar
```

### 3. Systemd Service (Linux)

```ini
# /etc/systemd/system/clinica.service
[Unit]
Description=Sistema de Gestión Clínica
After=network.target

[Service]
Type=simple
User=clinica
WorkingDirectory=/opt/clinica
ExecStart=/usr/bin/java -jar /opt/clinica/trabajo-0.0.1-SNAPSHOT.jar
Restart=always
RestartSec=10

Environment=SPRING_PROFILES_ACTIVE=prod
Environment=DB_PASSWORD=secure_password

[Install]
WantedBy=multi-user.target
```

```bash
# Habilitar y ejecutar servicio
sudo systemctl enable clinica
sudo systemctl start clinica
sudo systemctl status clinica
```

---

Con esta configuración, tendrás un entorno completo y robusto para desarrollar, probar y desplegar el sistema de gestión clínica.
