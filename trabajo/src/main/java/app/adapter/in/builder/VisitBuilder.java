package app.adapter.in.builder;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.VisitValidator;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.Visit;
import app.domain.model.VitalSigns;

@Component
public class VisitBuilder {

    @Autowired private VisitValidator validator;

    public Visit create(String patientId, String nurseId, VitalSigns vitalSigns) throws Exception {
        String pid = validator.patientIdValidator(patientId);
        String nid = validator.nurseIdValidator(nurseId);

        Patient p = new Patient();
        // Patient.id is long
        try {
            p.setId(Long.parseLong(pid));
        } catch (NumberFormatException e) {
            throw new Exception("El ID del paciente debe ser numérico: " + pid, e);
        }

        User nurse = new User();
        nurse.setUsername(nid);

        Visit v = new Visit();
        v.setVisitId(UUID.randomUUID().toString());
        v.setPatient(p);
        v.setNurse(nurse);
        v.setVitalSigns(vitalSigns);
        return v;
    }
}
