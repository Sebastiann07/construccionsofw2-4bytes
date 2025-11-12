package app.infrastructure.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EndpointLogger {

    private static final Logger logger = LoggerFactory.getLogger(EndpointLogger.class);

    @EventListener(ApplicationReadyEvent.class)
    public void logEndpointsOnStartup() {
        logger.info("================================================================================");
        logger.info("                    APLICACIÓN INICIADA - ENDPOINTS DISPONIBLES                 ");
        logger.info("================================================================================");
        logger.info("");
        
        // Endpoints de Admin
        logger.info("🔧 ROLE: ADMIN - Base URL: /api/admin");
        logger.info("   POST   /api/admin/patients              - Crear paciente");
        logger.info("   PUT    /api/admin/patients              - Actualizar paciente");
        logger.info("   POST   /api/admin/invoices              - Crear factura");
        logger.info("   POST   /api/admin/emergency-contacts    - Crear contacto de emergencia");
        logger.info("   POST   /api/admin/insurances            - Crear seguro");
        logger.info("   POST   /api/admin/visits                - Programar visita");
        logger.info("   PUT    /api/admin/users                 - Actualizar usuario");
        logger.info("");
        
        // Endpoints de Doctor
        logger.info("👨‍⚕️ ROLE: DOCTOR - Base URL: /api/doctor");
        logger.info("   POST   /api/doctor/medical-records      - Crear historia clínica");
        logger.info("   PUT    /api/doctor/medical-records      - Actualizar historia clínica");
        logger.info("   POST   /api/doctor/medical-orders       - Crear orden médica");
        logger.info("   POST   /api/doctor/medicines            - Prescribir medicina");
        logger.info("   POST   /api/doctor/procedures           - Prescribir procedimiento");
        logger.info("   POST   /api/doctor/diagnostic-helps     - Crear ayuda diagnóstica");
        logger.info("");
        
        // Endpoints de Nurse
        logger.info("👩‍⚕️ ROLE: NURSE - Base URL: /api/nurse");
        logger.info("   POST   /api/nurse/vital-signs                    - Registrar signos vitales");
        logger.info("   POST   /api/nurse/order-items/{id}/administer    - Administrar ítem de orden");
        logger.info("   POST   /api/nurse/diagnostic-helps               - Registrar ayuda diagnóstica");
        logger.info("   PUT    /api/nurse/medical-records                - Añadir observación a historia");
        logger.info("");
        
        // Endpoints de Human Resources
        logger.info("👥 ROLE: HUMAN RESOURCES - Base URL: /api/hr");
        logger.info("   POST   /api/hr/users                    - Crear usuario");
        logger.info("   PUT    /api/hr/users                    - Actualizar usuario");
        logger.info("   DELETE /api/hr/users/{id}              - Eliminar usuario");
        logger.info("");
        
        logger.info("================================================================================");
        logger.info("🚀 Servidor corriendo en: http://localhost:8081");
        logger.info("📊 Base de datos: MySQL en localhost:3308/Clinica");
        logger.info("================================================================================");
    }
}
