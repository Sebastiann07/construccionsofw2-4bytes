package app.domain.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.MedicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import app.application.exceptions.NotFoundException;

/**
 * Caso de uso: crear una orden médica en la clínica.
 * Solo puede ser creada por un médico y debe estar asociada a un paciente registrado.
 */
@Service
public class CreateMedicalOrder {

    @Autowired
    private UserPort userPort;

    @Autowired
    private PatientPort patientPort;

    @Autowired
    private MedicalOrderPort medicalOrderPort;

    public void create(MedicalOrder order) throws Exception {
        if (order == null) {
            throw new Exception("La orden médica no puede ser nula");
        }

        // Validar que el ID del doctor sea numérico
        long doctorId;
        try {
            doctorId = Long.parseLong(order.getDoctorId());
        } catch (NumberFormatException e) {
            throw new Exception("El ID del médico debe ser numérico");
        }

        // Buscar el doctor y validar su rol
        User doctor = userPort.findById(doctorId);
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("Solo los médicos pueden crear órdenes médicas");
        }

        // Validar que el ID del paciente sea numérico
        long patientId;
        try {
            patientId = Long.parseLong(order.getPatientId());
        } catch (NumberFormatException e) {
            throw new Exception("El ID del paciente debe ser numérico");
        }

        // Buscar el paciente
        Patient patient = patientPort.findById(patientId);
        if (patient == null) {
            throw new NotFoundException("La orden médica debe estar asociada a un paciente registrado");
        }

        // Generar fecha actual en formato de texto
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        order.setDate(currentDate);

        // Asociar entidades 
        order.setDoctor(doctor);
        order.setPatient(patient);

        // Guardar mediante el puerto
        medicalOrderPort.save(order);
    }
}
