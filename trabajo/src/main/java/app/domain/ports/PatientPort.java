package app.domain.ports;

import app.domain.model.Patient;
import app.domain.model.User;

public interface PatientPort {

    public Patient findById(long id) throws Exception;

    public Patient findByFullName(String fullName) throws Exception;

    public void save(User patient) throws Exception;
}
