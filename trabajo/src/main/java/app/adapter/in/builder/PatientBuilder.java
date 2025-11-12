package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.EmergencyContactValidator;
import app.adapter.in.validators.InsuranceValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.PersonValidator;
import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Patient;
import app.domain.model.enums.Gender;

@Component
public class PatientBuilder {

	@Autowired private PatientValidator patientValidator;
	@Autowired private PersonValidator personValidator;
	@Autowired private EmergencyContactValidator emergencyContactValidator;
	@Autowired private InsuranceValidator insuranceValidator;

	public Patient create(
			String id,
			String fullName,
			String birthDate,
			String address,
			String phone,
			String email,
			Integer age,
			String gender,
			EmergencyContact emergencyContact,
			Insurance insurance
	) throws Exception {

		// Permitir que el id venga nulo (se asumirá autogenerado en persistencia) y no forzar validación.
		String validId = null;
		if (id != null && !id.trim().isEmpty()) {
			validId = patientValidator.idValidator(id);
		}
		String validName = personValidator.nameValidator(fullName);
		String validBirth = personValidator.birthDateValidator(birthDate);
		String validAddress = personValidator.addressValidator(address);
		String validPhone = personValidator.phoneValidator(phone);
		String validEmail = personValidator.emailValidator(email);
		int validAge = personValidator.ageValidator(age);

		Gender g = null;
		if (gender != null && !gender.trim().isEmpty()) {
			String normalized = gender.trim().toUpperCase();
			// Aceptar iniciales comunes M / F y mapearlas
			if ("M".equals(normalized)) normalized = "MALE";
			else if ("F".equals(normalized)) normalized = "FEMALE";
			else if ("O".equals(normalized)) normalized = "OTHER";
			try {
				g = Gender.valueOf(normalized);
			} catch (IllegalArgumentException ex) {
				throw new Exception("Género inválido: " + gender + " (valores permitidos: MALE/FEMALE/OTHER o M/F/O)");
			}
		}

		// Validar anidados si vienen
		if (emergencyContact != null) {
			emergencyContactValidator.validate(emergencyContact);
		}
		if (insurance != null) {
			insuranceValidator.validate(insurance);
		}

		Patient p = new Patient();
		if (validId != null) {
			p.setId(Long.parseLong(validId));
		}
		p.setFullName(validName);
		p.setBirthDate(validBirth);
		p.setAddress(validAddress);
		p.setPhone(validPhone);
		p.setEmail(validEmail);
		p.setAge(validAge);
		p.setGender(g);
		p.setEmergencyContact(emergencyContact);
		p.setInsurance(insurance);
		return p;
	}
}
