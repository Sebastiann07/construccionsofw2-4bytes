package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.VitalSignsValidator;
import app.domain.model.VitalSigns;

@Component
public class VitalSignsBuilder {

    @Autowired private VitalSignsValidator validator;

    public VitalSigns create(String bloodPressure, Double temperature, Integer pulse, Double oxygenLevel) throws Exception {
        String bp = validator.bloodPressureValidator(bloodPressure);
        double temp = validator.temperatureValidator(temperature);
        int p = validator.pulseValidator(pulse);
        double ox = validator.oxygenLevelValidator(oxygenLevel);

        VitalSigns v = new VitalSigns();
        v.setBloodPressure(bp);
        v.setTemperature(temp);
        v.setPulse(p);
        v.setOxygenLevel(ox);
        return v;
    }
}
