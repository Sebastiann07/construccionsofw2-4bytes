package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class VitalSignsValidator {

    public String bloodPressureValidator(String bloodPressure) throws Exception {
        if (bloodPressure == null || bloodPressure.trim().isEmpty()) {
            throw new Exception("La presión arterial es obligatoria");
        }
        return bloodPressure.trim();
    }

    public double temperatureValidator(Double temperature) throws Exception {
        if (temperature == null || temperature <= 0) {
            throw new Exception("La temperatura debe ser mayor a 0");
        }
        return temperature;
    }

    public int pulseValidator(Integer pulse) throws Exception {
        if (pulse == null || pulse <= 0) {
            throw new Exception("El pulso debe ser mayor a 0");
        }
        return pulse;
    }

    public double oxygenLevelValidator(Double oxygen) throws Exception {
        if (oxygen == null || oxygen <= 0) {
            throw new Exception("El nivel de oxígeno debe ser mayor a 0");
        }
        return oxygen;
    }
}
