package app.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalOrder;
import app.domain.ports.MedicalOrderPort;
import app.infrastructure.persistence.entities.MedicalOrderEntity;
import app.infrastructure.persistence.mapper.MedicalOrderMapper;
import app.infrastructure.persistence.repository.MedicalOrderRepository;

@Service
public class MedicalOrderAdapter implements MedicalOrderPort {

	@Autowired
	private MedicalOrderRepository medicalOrderRepository;

	@Override
	public void save(MedicalOrder order) throws Exception {
		MedicalOrderEntity entity = MedicalOrderMapper.toEntity(order);
		medicalOrderRepository.save(entity);
	}

	@Override
	public MedicalOrder findById(String id) throws Exception {
		return medicalOrderRepository
				.findById(id)
				.map(MedicalOrderMapper::toDomain)
				.orElse(null);
	}

	@Override
	public List<MedicalOrder> findByPatient(String patientId) throws Exception {
		return medicalOrderRepository
				.findByPatientId(patientId)
				.stream()
				.map(MedicalOrderMapper::toDomain)
				.collect(Collectors.toList());
	}
}
