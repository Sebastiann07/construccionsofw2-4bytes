package app.domain.ports;

import app.domain.model.Patient;

public interface PatientPort {

    public Patient findById(long id) throws Exception;

    public void save(Patient patient) throws Exception;
}
