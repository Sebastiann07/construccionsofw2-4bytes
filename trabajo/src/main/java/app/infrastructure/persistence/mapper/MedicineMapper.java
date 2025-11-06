package app.infrastructure.persistence.mapper;

import app.domain.model.Medicine;
import app.infrastructure.persistence.entities.MedicineEntity;

public class MedicineMapper {

    public static Medicine toDomain(MedicineEntity e) {
        if (e == null) return null;
        Medicine m = new Medicine();
        m.setMedicineId(e.getMedicineId());
        if (e.getOrderNumber() != null) m.setOrderNumber(e.getOrderNumber());
        if (e.getItemNumber() != null) m.setItemNumber(e.getItemNumber());
        m.setMedicineName(e.getMedicineName());
        m.setDose(e.getDose());
        m.setTreatmentDuration(e.getTreatmentDuration());
        m.setCost(e.getCost());
        return m;
    }

    public static MedicineEntity toEntity(Medicine m) {
        if (m == null) return null;
        MedicineEntity e = new MedicineEntity();
        e.setMedicineId(m.getMedicineId());
        e.setOrderNumber(m.getOrderNumber());
        e.setItemNumber(m.getItemNumber());
        e.setMedicineName(m.getMedicineName());
        e.setDose(m.getDose());
        e.setTreatmentDuration(m.getTreatmentDuration());
        e.setCost(m.getCost());
        return e;
    }
}
