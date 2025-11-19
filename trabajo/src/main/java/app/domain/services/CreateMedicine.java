package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.Medicine;
import app.domain.ports.MedicinePort;
import app.application.exceptions.NotFoundException;

/**
 * Caso de uso: gestionar medicamentos.
 * Permite registrar, actualizar y eliminar medicamentos del sistema.
 */
@Service
public class CreateMedicine {

    private final MedicinePort medicinePort;

    public CreateMedicine(MedicinePort medicinePort) {
        this.medicinePort = medicinePort;
    }

    public void create(Medicine medicine) throws Exception {
        if (medicine == null) {
            throw new Exception("El medicamento no puede ser nulo");
        }

        if (medicinePort.findByMedicineId(medicine.getMedicineId()) != null) {
            throw new Exception("Ya existe un medicamento con este ID");
        }

        medicinePort.save(medicine);
    }

    public void update(Medicine medicine) throws Exception {
        if (medicinePort.findByMedicineId(medicine.getMedicineId()) == null) {
            throw new NotFoundException("No existe un medicamento con este ID para actualizar");
        }

        medicinePort.update(medicine);
    }

    public void delete(Medicine medicine) throws Exception {
        if (medicinePort.findByMedicineId(medicine.getMedicineId()) == null) {
            throw new NotFoundException("No existe un medicamento con este ID para eliminar");
        }

        medicinePort.delete(medicine);
    }
}
