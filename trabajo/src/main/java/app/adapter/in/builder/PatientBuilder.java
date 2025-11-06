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

		String validId = patientValidator.idValidator(id);
		String validName = personValidator.nameValidator(fullName);
		String validBirth = personValidator.birthDateValidator(birthDate);
		String validAddress = personValidator.addressValidator(address);
		String validPhone = personValidator.phoneValidator(phone);
		String validEmail = personValidator.emailValidator(email);
		int validAge = personValidator.ageValidator(age);

		Gender g = null;
		if (gender != null && !gender.trim().isEmpty()) {
			try {
				g = Gender.valueOf(gender.trim().toUpperCase());
			} catch (IllegalArgumentException ex) {
				throw new Exception("Género inválido: " + gender);
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
		p.setId(Long.parseLong(validId));
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
