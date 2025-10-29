package app.domain.ports;

import java.util.List;

import app.domain.model.Medicine;

public interface MedicinePort {

    void save(Medicine medicine) throws Exception;

    Medicine findByMedicineId(String medicineId) throws Exception;

    Medicine findByName(String name) throws Exception;

    void update(Medicine medicine) throws Exception;

    void delete(Medicine medicine) throws Exception;

    List<Medicine> findAll() throws Exception;
}
