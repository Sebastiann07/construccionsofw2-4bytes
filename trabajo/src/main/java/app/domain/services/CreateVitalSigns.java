package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.VitalSigns;
import app.domain.ports.VitalSignsPort;

/**
 * Caso de uso: registrar los signos vitales de un paciente.
 */
@Service
public class CreateVitalSigns {

    private final VitalSignsPort vitalSignsPort;

    public CreateVitalSigns(VitalSignsPort vitalSignsPort) {
        this.vitalSignsPort = vitalSignsPort;
    }

    public void create(long patientId, VitalSigns vitalSigns) throws Exception {
        if (vitalSigns == null) {
            throw new Exception("Los signos vitales no pueden ser nulos");
        }

        if (patientId <= 0) {
            throw new Exception("Debe proporcionar un patientId válido");
        }

        if (vitalSigns.getBloodPressure() == null || vitalSigns.getBloodPressure().isEmpty()) {
            throw new Exception("Debe ingresar una presión arterial válida");
        }

        if (vitalSigns.getTemperature() <= 0) {
            throw new Exception("Debe ingresar una temperatura válida");
        }

        if (vitalSigns.getPulse() <= 0) {
            throw new Exception("Debe ingresar un pulso válido");
        }

        if (vitalSigns.getOxygenLevel() <= 0) {
            throw new Exception("Debe ingresar un nivel de oxígeno válido");
        }

        vitalSignsPort.save(patientId, vitalSigns);
    }
}
