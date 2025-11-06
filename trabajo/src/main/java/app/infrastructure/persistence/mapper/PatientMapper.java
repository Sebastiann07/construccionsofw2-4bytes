package app.infrastructure.persistence.mapper;

import app.domain.model.Patient;
import app.domain.model.enums.Gender;
import app.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;
        Patient p = new Patient();
        if (entity.getId() != null) p.setId(entity.getId());
        p.setFullName(entity.getFullName());
        p.setBirthDate(entity.getBirthDate());
        p.setAddress(entity.getAddress());
        p.setPhone(entity.getPhone());
        p.setEmail(entity.getEmail());
        if (entity.getAge() != null) p.setAge(entity.getAge());
        if (entity.getGender() != null) {
            try { p.setGender(Gender.valueOf(entity.getGender())); } catch (IllegalArgumentException ex) { /* ignore */ }
        }
        // emergencyContact / insurance se dejan para adapters propios
        return p;
    }

    public static PatientEntity toEntity(Patient p) {
        if (p == null) return null;
        PatientEntity e = new PatientEntity();
        if (p.getId() != 0) e.setId(p.getId());
        e.setFullName(p.getFullName());
        e.setBirthDate(p.getBirthDate());
        e.setAddress(p.getAddress());
        e.setPhone(p.getPhone());
        e.setEmail(p.getEmail());
        e.setAge(p.getAge());
        e.setGender(p.getGender() != null ? p.getGender().name() : null);
        return e;
    }
}
