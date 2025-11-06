package app.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Medicine;
import app.domain.ports.MedicinePort;
import app.infrastructure.persistence.entities.MedicineEntity;
import app.infrastructure.persistence.mapper.MedicineMapper;
import app.infrastructure.persistence.repository.MedicineRepository;

@Service
public class MedicineAdapter implements MedicinePort {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public void save(Medicine medicine) throws Exception {
        MedicineEntity entity = MedicineMapper.toEntity(medicine);
        medicineRepository.save(entity);
    }

    @Override
    public Medicine findByMedicineId(String medicineId) throws Exception {
        return medicineRepository.findById(medicineId).map(MedicineMapper::toDomain).orElse(null);
    }

    @Override
    public Medicine findByName(String name) throws Exception {
        return medicineRepository.findByMedicineName(name).map(MedicineMapper::toDomain).orElse(null);
    }

    @Override
    public void update(Medicine medicine) throws Exception {
        MedicineEntity entity = MedicineMapper.toEntity(medicine);
        medicineRepository.save(entity);
    }

    @Override
    public void delete(Medicine medicine) throws Exception {
        if (medicine.getMedicineId() != null) {
            medicineRepository.deleteById(medicine.getMedicineId());
        } else if (medicine.getMedicineName() != null) {
            medicineRepository.findByMedicineName(medicine.getMedicineName())
                .ifPresent(m -> medicineRepository.deleteById(m.getMedicineId()));
        }
    }

    @Override
    public List<Medicine> findAll() throws Exception {
        return medicineRepository.findAll().stream().map(MedicineMapper::toDomain).collect(Collectors.toList());
    }
}
