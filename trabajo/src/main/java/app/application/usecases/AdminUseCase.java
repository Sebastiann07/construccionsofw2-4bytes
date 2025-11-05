package app.application.usecases;

import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.Visit;
import app.domain.services.CreateEmergencyContact;
import app.domain.services.CreateInsurance;
import app.domain.services.CreateInvoice;
import app.domain.services.CreatePatient;
import app.domain.services.CreateUser;
import app.domain.services.CreateVisit;
import app.domain.services.DeleteUser;
import app.domain.services.UpdatePatient;
import app.domain.services.UpdateUser;

@Service
public class AdminUseCase {

    private final CreatePatient createPatient;
    private final UpdatePatient updatePatient;
    private final CreateInvoice createInvoice;
    private final CreateEmergencyContact createEmergencyContact;
    private final CreateInsurance createInsurance;
    private final CreateVisit createVisit;
    private final CreateUser createUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;

    public AdminUseCase(CreatePatient createPatient,
                        UpdatePatient updatePatient,
                        CreateInvoice createInvoice,
                        CreateEmergencyContact createEmergencyContact,
                        CreateInsurance createInsurance,
                        CreateVisit createVisit,
                        CreateUser createUser,
                        UpdateUser updateUser,
                        DeleteUser deleteUser) {
        this.createPatient = createPatient;
        this.updatePatient = updatePatient;
        this.createInvoice = createInvoice;
        this.createEmergencyContact = createEmergencyContact;
        this.createInsurance = createInsurance;
        this.createVisit = createVisit;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }

    /**
     * Crear paciente (orquesta el servicio de dominio).
     */
    public void createPatient(Patient patient) throws Exception {
        createPatient.createPatient(patient);
    }

    /**
     * Actualizar la información de un paciente.
     */
    public void updatePatient(Patient patient) throws Exception {
        updatePatient.updatePatient(patient);
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

    /**
     * Programar una nueva cita/visita para un paciente.
     */
    public void scheduleVisit(Visit visit) throws Exception {
        createVisit.createVisit(visit);
    }

    /**
     * Crear un nuevo usuario en el sistema (médico, enfermera, etc.).
     */
    public void createUser(User user) throws Exception {
        createUser.create(user);
    }

    /**
     * Actualizar un usuario existente.
     */
    public void updateUser(User user) throws Exception {
        updateUser.update(user);
    }

    /**
     * Eliminar un usuario del sistema.
     */
    public void deleteUser(String userId) throws Exception {
        deleteUser.delete(userId);
    }
}