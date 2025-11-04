package app.application.usecases;

import org.springframework.stereotype.Service;

import app.domain.model.VitalSigns;
import app.domain.model.Medicine;
import app.domain.model.Procedure;
import app.domain.services.CreateVitalSigns;
import app.domain.services.CreateMedicine;
import app.domain.services.CreateProcedure;

/**
 * Caso de uso: Enfermera.
 * Gestiona el registro de signos vitales, medicamentos y procedimientos aplicados a los pacientes.
 */
@Service
public class NurseUseCase {

    private final CreateVitalSigns createVitalSigns;
    private final CreateMedicine createMedicine;
    private final CreateProcedure createProcedure;

    public NurseUseCase(CreateVitalSigns createVitalSigns,
                        CreateMedicine createMedicine,
                        CreateProcedure createProcedure) {
        this.createVitalSigns = createVitalSigns;
        this.createMedicine = createMedicine;
        this.createProcedure = createProcedure;
    }

    /**
     * Registrar los signos vitales de un paciente.
     */
    public void createVitalSigns(VitalSigns vitalSigns) throws Exception {
        createVitalSigns.create(vitalSigns);
    }

    /**
     * Registrar un medicamento administrado a un paciente.
     */
    public void createMedicine(Medicine medicine) throws Exception {
        createMedicine.create(medicine);
    }

    /**
     * Registrar un procedimiento realizado a un paciente.
     */
    public void createProcedure(Procedure procedure) throws Exception {
        createProcedure.create(procedure);
    }
}
