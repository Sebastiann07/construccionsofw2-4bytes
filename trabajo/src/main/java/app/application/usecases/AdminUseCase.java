package app.application.usecases;

import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.services.CreatePatient;
import app.domain.services.CreateInvoice;
import app.domain.services.CreateEmergencyContact;
import app.domain.services.CreateInsurance;

@Service
public class AdminUseCase {

    private final CreatePatient createPatient;
    private final CreateInvoice createInvoice;
    private final CreateEmergencyContact createEmergencyContact;
    private final CreateInsurance createInsurance;

    public AdminUseCase(CreatePatient createPatient,
                        CreateInvoice createInvoice,
                        CreateEmergencyContact createEmergencyContact,
                        CreateInsurance createInsurance) {
        this.createPatient = createPatient;
        this.createInvoice = createInvoice;
        this.createEmergencyContact = createEmergencyContact;
        this.createInsurance = createInsurance;
    }

    /**
     * Crear paciente (orquesta el servicio de dominio).
     */
    public void createPatient(Patient patient) throws Exception {
        createPatient.createPatient(patient);
    }

    /**
     * Crear factura simple: delega al servicio de dominio.
     */
    public void createInvoice(Invoice invoice) throws Exception {
        createInvoice.createInvoice(invoice);
    }

    /**
     * Registrar contacto de emergencia para un paciente (por id).
     * Se delega al servicio especializado.
     */
    public void createEmergencyContact(EmergencyContact contact) throws Exception {
         createEmergencyContact.createEmergencyContact(contact);
    }

    /**
     * Registrar póliza / seguro para un paciente (por id).
     */
    public void createInsurance(Insurance insurance) throws Exception {
        createInsurance.createInsurance(insurance);
        
    }
}