package app.infrastructure.persistence.mapper;

import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.infrastructure.persistence.entities.MedicalOrderEntity;

public class MedicalOrderMapper {

    public static MedicalOrder toDomain(MedicalOrderEntity entity) {
        if (entity == null) return null;
        MedicalOrder order = new MedicalOrder();
        order.setOrderNumber(entity.getOrderNumber());
        order.setPatientId(entity.getPatientId());
        order.setDoctorId(entity.getDoctorId());
        order.setDate(entity.getDate());
        order.setObservations(entity.getObservations());
        // Opcional: poblar objetos anidados con sólo el ID
        if (entity.getDoctorId() != null) {
            User doctor = new User();
            doctor.setId(Long.parseLong(entity.getDoctorId()));
            order.setDoctor(doctor);
        }
        if (entity.getPatientId() != null) {
            Patient patient = new Patient();
            try {
                patient.setId(Long.parseLong(entity.getPatientId()));
            } catch (NumberFormatException e) {
                // Si el ID no es numérico, lo ignoramos en el objeto anidado
            }
            order.setPatient(patient);
        }
        return order;
    }

    public static MedicalOrderEntity toEntity(MedicalOrder order) {
        if (order == null) return null;
        MedicalOrderEntity entity = new MedicalOrderEntity();
        entity.setOrderNumber(order.getOrderNumber());
        entity.setPatientId(order.getPatientId());
        entity.setDoctorId(order.getDoctorId());
        entity.setDate(order.getDate());
        entity.setObservations(order.getObservations());
        return entity;
    }
}
