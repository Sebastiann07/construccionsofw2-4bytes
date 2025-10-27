package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.ports.PatientPort;
import app.domain.model.User;

@Service
public class CreatePatient {
	
	@Autowired
	private PatientPort patientPort;

	public CreatePatient(PatientPort patientPort) {
		this.patientPort = patientPort;
	}

    public void createPerson(User patient) throws Exception {
		if (patientPort.findById(patient.getId()) != null) { 
			throw new Exception("Ya existe una persona con este documento");
		}
		patientPort.save(patient);
		}

}
