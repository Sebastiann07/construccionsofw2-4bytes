package app.application.usecases;

import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticHelp;
import app.domain.model.MedicalRecord;
import app.domain.model.VitalSigns;
import app.domain.services.CreateDiagnosticHelp;
import app.domain.services.CreateVitalSigns;
import app.domain.services.UpdateMedicalRecord;
import app.domain.services.UpdateOrderItemStatus;

/**
 * Caso de uso: Enfermera.
 * Gestiona el registro de signos vitales, medicamentos y procedimientos aplicados a los pacientes.
 */
@Service
public class NurseUseCase {

    private final CreateVitalSigns createVitalSigns;
    private final UpdateOrderItemStatus updateOrderItemStatus;
    private final CreateDiagnosticHelp createDiagnosticHelp;
    private final UpdateMedicalRecord updateMedicalRecord;

    public NurseUseCase(CreateVitalSigns createVitalSigns,
                        UpdateOrderItemStatus updateOrderItemStatus,
                        CreateDiagnosticHelp createDiagnosticHelp,
                        UpdateMedicalRecord updateMedicalRecord) {
        this.createVitalSigns = createVitalSigns;
        this.updateOrderItemStatus = updateOrderItemStatus;
        this.createDiagnosticHelp = createDiagnosticHelp;
        this.updateMedicalRecord = updateMedicalRecord;
    }

    /**
     * Registrar los signos vitales de un paciente.
     */
    public void recordVitalSigns(long patientId, VitalSigns vitalSigns) throws Exception {
        createVitalSigns.create(patientId, vitalSigns);
    }

    /**
     * Registrar la administración de un medicamento o la realización de un procedimiento.
     * @param orderItemId El ID del ítem de la orden (medicamento o procedimiento).
     * @param notes Observaciones de la enfermera.
     */
    public void administerOrderItem(String orderItemId, String notes) throws Exception {
        updateOrderItemStatus.updateStatus(orderItemId, "ADMINISTERED", notes);
    }

    /**
     * Registrar una prueba de diagnóstico realizada a un paciente.
     */
    public void recordDiagnosticHelp(DiagnosticHelp diagnosticHelp) throws Exception {
        createDiagnosticHelp.create(diagnosticHelp);
    }

    /**
     * Añade una observación al historial médico del paciente.
     */
    public void addObservationToMedicalRecord(MedicalRecord record) throws Exception {
        updateMedicalRecord.update(record);
    }
}
