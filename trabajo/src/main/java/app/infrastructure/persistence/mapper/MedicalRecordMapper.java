package app.infrastructure.persistence.mapper;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.domain.model.MedicalRecord;
import app.infrastructure.persistence.entities.MedicalRecordEntity;

public class MedicalRecordMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static MedicalRecord toDomain(MedicalRecordEntity entity) {
        if (entity == null) return null;
        try {
            Map<String, Object> dataMap = objectMapper.readValue(entity.getData(), new TypeReference<>() {});
            return new MedicalRecord(
                String.valueOf(entity.getId()),
                entity.getPatientId(),
                dataMap
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir MedicalRecordEntity a dominio", e);
        }
    }

    public static MedicalRecordEntity toEntity(MedicalRecord record) {
        if (record == null) return null;
        try {
            String jsonData = objectMapper.writeValueAsString(record.getData());
            MedicalRecordEntity entity = new MedicalRecordEntity();
            if (record.getId() != null) {
                entity.setId(Long.parseLong(record.getId()));
            }
            entity.setPatientId(record.getPatientId());
            entity.setData(jsonData);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir MedicalRecord a entidad", e);
        }
    }
}
