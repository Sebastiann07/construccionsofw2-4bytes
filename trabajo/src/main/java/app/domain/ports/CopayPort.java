package app.domain.ports;

import java.util.List;

import app.domain.model.CopayRecord;

public interface CopayPort {

    List<CopayRecord> findByPatientId(String patientId);

    void save(CopayRecord copayRecord);
}
