# API Endpoints - Clínica

Base URL: http://localhost:8081

Autenticación: La mayoría de endpoints requieren JWT en el header Authorization: Bearer <token> y rol correspondiente. Primero inicia sesión.

1) Autenticación

POST /api/auth/login
- Body:
{
  "username": "admin",
  "password": "admin123"
}
- Response 200:
{
  "token": "<jwt>"
}
- curl (PowerShell):
curl -X POST "http://localhost:8081/api/auth/login" -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'

2) Admin API (/api/admin) [Rol: ADMIN]

2.1 Crear paciente
POST /api/admin/patients
- Body:
{
  "fullName": "Juan Perez",
  "birthDate": "1988-05-15",
  "address": "Calle 123",
  "phone": "+573001234567",
  "email": "juan@example.com",
  "age": "35",
  "gender": "MALE"
}
- Response 200:
{
  "id": 1,
  "fullName": "Juan Perez",
  "email": "juan@example.com",
  "phone": "+573001234567",
  "gender": "MALE"
}
- curl:
curl -X POST "http://localhost:8081/api/admin/patients" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"fullName":"Juan Perez","birthDate":"1988-05-15","address":"Calle 123","phone":"+573001234567","email":"juan@example.com","age":"35","gender":"MALE"}'

2.2 Actualizar paciente
PUT /api/admin/patients
- Body:
{
  "id": "1",
  "fullName": "Juan Carlos Perez",
  "birthDate": "1988-05-15",
  "address": "Calle 456",
  "phone": "+573009876543",
  "email": "juan.c@example.com",
  "age": "36",
  "gender": "MALE"
}
- Response 200:
{
  "id": 1,
  "fullName": "Juan Carlos Perez",
  "email": "juan.c@example.com",
  "phone": "+573009876543",
  "gender": "MALE"
}
- curl:
curl -X PUT "http://localhost:8081/api/admin/patients" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"id":"1","fullName":"Juan Carlos Perez","birthDate":"1988-05-15","address":"Calle 456","phone":"+573009876543","email":"juan.c@example.com","age":"36","gender":"MALE"}'

2.3 Crear factura
POST /api/admin/invoices
- Body:
{
  "invoiceNumber": "INV-001",
  "patientId": "1",
  "doctorId": "2",
  "insuranceCompany": "EPS Salud",
  "policyNumber": "POL-123",
  "policyActive": "true",
  "policyEndDate": "2025-12-31",
  "totalAmount": "150000",
  "copay": "15000",
  "insurerCharge": "135000"
}
- Response 200:
{
  "invoiceNumber": "INV-001",
  "patientId": 1,
  "doctorUsername": "dr.garcia",
  "totalAmount": 150000.0,
  "copay": 15000.0,
  "insurerCharge": 135000.0
}
- curl:
curl -X POST "http://localhost:8081/api/admin/invoices" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"invoiceNumber":"INV-001","patientId":"1","doctorId":"2","insuranceCompany":"EPS Salud","policyNumber":"POL-123","policyActive":"true","policyEndDate":"2025-12-31","totalAmount":"150000","copay":"15000","insurerCharge":"135000"}'

2.4 Crear contacto de emergencia
POST /api/admin/emergency-contacts
- Body:
{
  "name": "Maria Perez",
  "phone": "+573001112233",
  "relation": "Esposa"
}
- Response 200:
{
  "name": "Maria Perez",
  "phone": "+573001112233",
  "relation": "Esposa"
}
- curl:
curl -X POST "http://localhost:8081/api/admin/emergency-contacts" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"name":"Maria Perez","phone":"+573001112233","relation":"Esposa"}'

2.5 Crear seguro
POST /api/admin/insurances
- Body:
{
  "insuranceCompany": "EPS Salud",
  "policyNumber": "POL-123",
  "policyActive": "true",
  "policyEndDate": "2025-12-31"
}
- Response 200:
{
  "insuranceCompany": "EPS Salud",
  "policyNumber": "POL-123",
  "policyActive": true,
  "policyEndDate": "2025-12-31"
}
- curl:
curl -X POST "http://localhost:8081/api/admin/insurances" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"insuranceCompany":"EPS Salud","policyNumber":"POL-123","policyActive":"true","policyEndDate":"2025-12-31"}'

2.6 Programar visita
POST /api/admin/visits
- Body:
{
  "patientId": "1",
  "nurseId": "3",
  "bloodPressure": "120/80",
  "temperature": "36.7",
  "pulse": "72",
  "oxygenLevel": "98"
}
- Response 200:
{
  "visitId": "VIS-001",
  "patientId": 1,
  "nurseUsername": "nurse.maria",
  "bloodPressure": "120/80",
  "temperature": 36.7,
  "pulse": 72,
  "oxygenLevel": 98.0,
  "visitDate": "2025-11-12T10:00:00"
}
- curl:
curl -X POST "http://localhost:8081/api/admin/visits" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"patientId":"1","nurseId":"3","bloodPressure":"120/80","temperature":"36.7","pulse":"72","oxygenLevel":"98"}'

2.7 Actualizar usuario
PUT /api/admin/users
- Body:
{
  "id": "10",
  "fullName": "Ana Gomez",
  "birthDate": "1990-02-01",
  "address": "Cra 10",
  "phone": "+573001234000",
  "email": "ana@example.com",
  "age": "34",
  "username": "ana",
  "password": "secret123",
  "role": "NURSE"
}
- Response 200:
{
  "id": 10,
  "username": "ana",
  "role": "NURSE",
  "fullName": "Ana Gomez",
  "email": "ana@example.com",
  "phone": "+573001234000"
}
- curl:
curl -X PUT "http://localhost:8081/api/admin/users" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"id":"10","fullName":"Ana Gomez","birthDate":"1990-02-01","address":"Cra 10","phone":"+573001234000","email":"ana@example.com","age":"34","username":"ana","password":"secret123","role":"NURSE"}'

2.8 Crear usuarios por rol
POST /api/admin/users/{role}
- Endpoints: /doctor | /nurse | /human-resources | /support | /admin
- Body (común):
{
  "fullName": "Carlos Ruiz",
  "birthDate": "1985-01-20",
  "address": "Av 1",
  "phone": "+573001110000",
  "email": "carlos@example.com",
  "age": "39",
  "username": "carlos",
  "password": "StrongPass1"
}
- Response 201:
{
  "id": 20,
  "username": "carlos",
  "role": "DOCTOR",
  "fullName": "Carlos Ruiz",
  "email": "carlos@example.com",
  "phone": "+573001110000"
}
- curl (ejemplo doctor):
curl -X POST "http://localhost:8081/api/admin/users/doctor" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"fullName":"Carlos Ruiz","birthDate":"1985-01-20","address":"Av 1","phone":"+573001110000","email":"carlos@example.com","age":"39","username":"carlos","password":"StrongPass1"}'

Nota: GET /api/admin/users está pendiente (no implementado) y actualmente lanza error 501/exception.

3) Doctor API (/api/doctor) [Rol: DOCTOR]

3.1 Crear historia clínica
POST /api/doctor/medical-records
- Body:
{
  "doctorId": "2",
  "patientId": "1",
  "data": { "diagnosis": "HTA leve", "treatment": "Dieta baja en sodio" }
}
- Response 201:
{
  "id": "MR-001",
  "patientId": "1",
  "dataSize": 2
}
- curl:
curl -X POST "http://localhost:8081/api/doctor/medical-records" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"doctorId":"2","patientId":"1","data":{"diagnosis":"HTA leve","treatment":"Dieta baja en sodio"}}'

3.2 Actualizar historia clínica
PUT /api/doctor/medical-records
- Body:
{
  "id": "MR-001",
  "doctorId": "2",
  "patientId": "1",
  "data": { "observations": "Mejoría" }
}
- Response 200:
{
  "id": "MR-001",
  "patientId": "1"
}
- curl:
curl -X PUT "http://localhost:8081/api/doctor/medical-records" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"id":"MR-001","doctorId":"2","patientId":"1","data":{"observations":"Mejoría"}}'

3.3 Crear orden médica
POST /api/doctor/medical-orders
- Body:
{
  "doctorId": "2",
  "patientId": "1",
  "date": "2025-11-12",
  "observations": "Control"
}
- Response 201:
{
  "orderNumber": "1001",
  "patientId": "1",
  "doctorUsername": "dr.garcia",
  "date": "2025-11-12",
  "observations": "Control"
}
- curl:
curl -X POST "http://localhost:8081/api/doctor/medical-orders" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"doctorId":"2","patientId":"1","date":"2025-11-12","observations":"Control"}'

3.4 Prescribir medicina
POST /api/doctor/medicines
- Body:
{
  "medicineId": "MED-001",
  "medicineName": "Losartan",
  "orderNumber": "1001",
  "itemNumber": "1",
  "dose": "50mg c/12h",
  "treatmentDuration": "30 dias",
  "cost": "25000"
}
- Response 201:
{
  "medicineId": "MED-001",
  "medicineName": "Losartan",
  "orderNumber": 1001,
  "itemNumber": 1,
  "dose": "50mg c/12h",
  "treatmentDuration": "30 dias",
  "cost": 25000.0
}
- curl:
curl -X POST "http://localhost:8081/api/doctor/medicines" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"medicineId":"MED-001","medicineName":"Losartan","orderNumber":"1001","itemNumber":"1","dose":"50mg c/12h","treatmentDuration":"30 dias","cost":"25000"}'

3.5 Prescribir procedimiento
POST /api/doctor/procedures
- Body:
{
  "orderNumber": "1001",
  "itemNumber": "2",
  "procedureId": "PROC-01",
  "procedureName": "ECG",
  "quantity": "1",
  "frequency": "Una vez",
  "cost": "50000",
  "requiresSpecialist": "false",
  "specialistTypeId": null
}
- Response 201:
{
  "orderNumber": 1001,
  "itemNumber": 2,
  "procedureId": "PROC-01",
  "procedureName": "ECG",
  "quantity": 1,
  "frequency": "Una vez",
  "cost": 50000.0,
  "requiresSpecialist": false,
  "specialistTypeId": null
}
- curl:
curl -X POST "http://localhost:8081/api/doctor/procedures" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"orderNumber":"1001","itemNumber":"2","procedureId":"PROC-01","procedureName":"ECG","quantity":"1","frequency":"Una vez","cost":"50000","requiresSpecialist":"false","specialistTypeId":null}'

3.6 Crear ayuda diagnóstica
POST /api/doctor/diagnostic-helps
- Body:
{
  "orderNumber": "1001",
  "itemNumber": "3",
  "diagnosticId": "LAB-01",
  "diagnosticName": "Perfil lipidico",
  "quantity": "1",
  "cost": "60000",
  "requiresSpecialist": "false",
  "specialistTypeId": null
}
- Response 201:
{
  "orderNumber": 1001,
  "itemNumber": 3,
  "diagnosticId": "LAB-01",
  "diagnosticName": "Perfil lipidico",
  "quantity": 1,
  "cost": 60000.0,
  "requiresSpecialist": false,
  "specialistTypeId": null
}
- curl:
curl -X POST "http://localhost:8081/api/doctor/diagnostic-helps" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"orderNumber":"1001","itemNumber":"3","diagnosticId":"LAB-01","diagnosticName":"Perfil lipidico","quantity":"1","cost":"60000","requiresSpecialist":"false","specialistTypeId":null}'

4) Nurse API (/api/nurse) [Rol: NURSE]

4.1 Registrar signos vitales
POST /api/nurse/vital-signs
- Body:
{
  "patientId": "1",
  "bloodPressure": "130/85",
  "temperature": "36.8",
  "pulse": "78",
  "oxygenLevel": "98"
}
- Response 201:
{
  "patientId": "1",
  "bloodPressure": "130/85",
  "temperature": 36.8,
  "pulse": 78,
  "oxygenLevel": 98.0
}
- curl:
curl -X POST "http://localhost:8081/api/nurse/vital-signs" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"patientId":"1","bloodPressure":"130/85","temperature":"36.8","pulse":"78","oxygenLevel":"98"}'

4.2 Administrar ítem de orden
POST /api/nurse/order-items/{id}/administer
- Path: {id} = "ORD-1001-1"
- Body:
{
  "notes": "Administrado sin novedad"
}
- Response 200:
{
  "orderItemId": "ORD-1001-1",
  "status": "ADMINISTERED"
}
- curl:
curl -X POST "http://localhost:8081/api/nurse/order-items/ORD-1001-1/administer" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"notes":"Administrado sin novedad"}'

4.3 Registrar ayuda diagnóstica
POST /api/nurse/diagnostic-helps
- Body:
{
  "orderNumber": "1001",
  "itemNumber": "3",
  "diagnosticId": "LAB-01",
  "diagnosticName": "Perfil lipidico",
  "quantity": "1",
  "cost": "60000",
  "requiresSpecialist": "false",
  "specialistTypeId": null
}
- Response 201:
{
  "orderNumber": 1001,
  "itemNumber": 3,
  "diagnosticId": "LAB-01",
  "diagnosticName": "Perfil lipidico",
  "quantity": 1,
  "cost": 60000.0
}
- curl:
curl -X POST "http://localhost:8081/api/nurse/diagnostic-helps" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"orderNumber":"1001","itemNumber":"3","diagnosticId":"LAB-01","diagnosticName":"Perfil lipidico","quantity":"1","cost":"60000","requiresSpecialist":"false","specialistTypeId":null}'

4.4 Añadir observación a historia
PUT /api/nurse/medical-records
- Body:
{
  "id": "MR-001",
  "doctorId": "2",
  "patientId": "1",
  "data": { "nurseObservation": "Paciente estable" }
}
- Response 200:
{
  "id": "MR-001",
  "patientId": "1"
}
- curl:
curl -X PUT "http://localhost:8081/api/nurse/medical-records" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"id":"MR-001","doctorId":"2","patientId":"1","data":{"nurseObservation":"Paciente estable"}}'

5) Recursos Humanos (/api/hr) [Rol: HUMANRESOURCES]

5.1 Crear usuario
POST /api/hr/users
- Body:
{
  "fullName": "Laura Martinez",
  "birthDate": "1992-08-10",
  "address": "Calle 9",
  "phone": "+573009990000",
  "email": "laura@example.com",
  "age": "32",
  "username": "laura",
  "password": "StrongPass1",
  "role": "NURSE"
}
- Response 201:
{
  "id": 30,
  "username": "laura",
  "role": "NURSE",
  "fullName": "Laura Martinez",
  "email": "laura@example.com",
  "phone": "+573009990000"
}
- curl:
curl -X POST "http://localhost:8081/api/hr/users" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"fullName":"Laura Martinez","birthDate":"1992-08-10","address":"Calle 9","phone":"+573009990000","email":"laura@example.com","age":"32","username":"laura","password":"StrongPass1","role":"NURSE"}'

5.2 Actualizar usuario
PUT /api/hr/users
- Body:
{
  "id": "30",
  "fullName": "Laura M.",
  "birthDate": "1992-08-10",
  "address": "Calle 9",
  "phone": "+573009990000",
  "email": "laura.m@example.com",
  "age": "32",
  "username": "laura",
  "password": "StrongPass1",
  "role": "NURSE"
}
- Response 200:
{
  "id": 30,
  "username": "laura",
  "role": "NURSE",
  "fullName": "Laura M.",
  "email": "laura.m@example.com",
  "phone": "+573009990000"
}
- curl:
curl -X PUT "http://localhost:8081/api/hr/users" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"id":"30","fullName":"Laura M.","birthDate":"1992-08-10","address":"Calle 9","phone":"+573009990000","email":"laura.m@example.com","age":"32","username":"laura","password":"StrongPass1","role":"NURSE"}'

5.3 Eliminar usuario
DELETE /api/hr/users/{id}
- Response 200:
{
  "id": 30
}
- curl:
curl -X DELETE "http://localhost:8081/api/hr/users/30" -H "Authorization: Bearer <token>"

Notas:
- Todos los campos numéricos/booleanos en requests se envían como String según los DTOs actuales; el backend los transforma a sus tipos.
- Usa 127.0.0.1 si tienes problemas con localhost.
- Asegura incluir Authorization en endpoints de rol.
