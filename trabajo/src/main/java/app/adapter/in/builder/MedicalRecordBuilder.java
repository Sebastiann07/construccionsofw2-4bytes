package app.adapter.in.builder;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.MedicalRecordValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;

/**
 * Builder para crear objetos MedicalRecord validados antes de su persistencia.
 */
@Component
public class MedicalRecordBuilder {

    @Autowired
    private MedicalRecordValidator medicalRecordValidator;

    @Autowired
    private PatientValidator patientValidator;

    @Autowired
    private UserValidator userValidator;

    /**
     * Crea un nuevo registro médico validado y con ID generado.
     *
     * @param doctorId Documento o ID del médico que registra la historia (se usa aquí como username)
     * @param patientId ID del paciente (se espera que el validator devuelva string que represente un número)
     * @param data Información médica no estructurada (síntomas, diagnóstico, etc.)
     * @return un objeto MedicalRecord listo para guardar
     * @throws Exception si alguna validación falla
     */
    public MedicalRecord create(String doctorId, String patientId, Map<String, Object> data) throws Exception {
        // Validar datos básicos (los validators devuelven strings según implementaste)
        String validDoctorId = userValidator.documentValidator(doctorId);
        String validPatientId = patientValidator.idValidator(patientId);
        Map<String, Object> validData = medicalRecordValidator.dataValidator(data);

        // Crear y poblar User (doctor)
        User doctor = new User();
        // Tu User no tiene setDocument; uso setUsername para almacenar el identificador validado.
        doctor.setUsername(validDoctorId);

        // Crear y poblar Patient
        Patient patient = new Patient();
        try {
            long patientIdLong = Long.parseLong(validPatientId); // convertir String -> long porque Patient.setId espera long
            // Si tu Patient tiene setId(long) (según errores previos), úsalo:
            patient.setId(patientIdLong);
        } catch (NumberFormatException e) {
            throw new Exception("El ID del paciente debe ser numérico: " + validPatientId, e);
        }

        // Construir el registro médico
        MedicalRecord record = new MedicalRecord();
        record.setId(UUID.randomUUID().toString());
        // record.setPatientId espera String: convertimos el long a String
        record.setPatientId(String.valueOf(patient.getId()));
        record.setData(validData);

        return record;
    }
}
