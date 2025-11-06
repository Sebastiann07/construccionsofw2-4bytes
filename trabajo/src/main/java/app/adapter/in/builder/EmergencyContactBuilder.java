package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.EmergencyContactValidator;
import app.domain.model.EmergencyContact;

@Component
public class EmergencyContactBuilder {

    @Autowired private EmergencyContactValidator validator;

    public EmergencyContact create(String name, String phone, String relation) throws Exception {
        EmergencyContact c = new EmergencyContact();
        c.setEmergencyContactName(name);
        c.setEmergencyContactPhone(phone);
        c.setEmergencyContactRelation(relation);
        validator.validate(c);
        return c;
    }
}
