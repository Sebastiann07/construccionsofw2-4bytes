package app.infrastructure.persistence.mapper;

import app.domain.model.EmergencyContact;
import app.infrastructure.persistence.entities.EmergencyContactEntity;

public class EmergencyContactMapper {

    public static EmergencyContact toDomain(EmergencyContactEntity e) {
        if (e == null) return null;
        EmergencyContact c = new EmergencyContact();
        c.setEmergencyContactPhone(e.getEmergencyContactPhone());
        c.setEmergencyContactName(e.getEmergencyContactName());
        c.setEmergencyContactRelation(e.getEmergencyContactRelation());
        return c;
    }

    public static EmergencyContactEntity toEntity(EmergencyContact c) {
        if (c == null) return null;
        EmergencyContactEntity e = new EmergencyContactEntity();
        e.setEmergencyContactPhone(c.getEmergencyContactPhone());
        e.setEmergencyContactName(c.getEmergencyContactName());
        e.setEmergencyContactRelation(c.getEmergencyContactRelation());
        return e;
    }
}
