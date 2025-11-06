package app.adapter.in.builder;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.MedicalOrderValidator;
import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;

@Component
public class MedicalOrderBuilder {

    @Autowired private MedicalOrderValidator validator;

    public MedicalOrder create(String doctorId, String patientId, String date, String observations) throws Exception {
        String did = validator.doctorIdValidator(doctorId);
        String pid = validator.patientIdValidator(patientId);
        String d = validator.dateValidator(date);
        String obs = validator.observationsValidator(observations);

        User doctor = new User();
        doctor.setUsername(did);

        Patient patient = new Patient();
        try {
            patient.setId(Long.parseLong(pid));
        } catch (NumberFormatException e) {
            throw new Exception("El ID del paciente debe ser numérico: " + pid, e);
        }

        MedicalOrder order = new MedicalOrder();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setDoctorId(did);
        order.setPatientId(pid);
        order.setDate(d);
        order.setObservations(obs);
        order.setDoctor(doctor);
        order.setPatient(patient);
        return order;
    }
}
