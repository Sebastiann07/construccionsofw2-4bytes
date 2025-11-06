package app.infrastructure.persistence.mapper;

import app.domain.model.VitalSigns;
import app.infrastructure.persistence.entities.VitalSignsEntity;

public class VitalSignsMapper {

    public static VitalSigns toDomain(VitalSignsEntity e) {
        if (e == null) return null;
        VitalSigns v = new VitalSigns();
        v.setBloodPressure(e.getBloodPressure());
        v.setTemperature(e.getTemperature());
        v.setPulse(e.getPulse());
        v.setOxygenLevel(e.getOxygenLevel());
        return v;
    }

    public static VitalSignsEntity toEntity(long patientId, VitalSigns v) {
        if (v == null) return null;
        VitalSignsEntity e = new VitalSignsEntity();
        e.setPatientId(patientId);
        e.setBloodPressure(v.getBloodPressure());
        e.setTemperature(v.getTemperature());
        e.setPulse(v.getPulse());
        e.setOxygenLevel(v.getOxygenLevel());
        return e;
    }
}
