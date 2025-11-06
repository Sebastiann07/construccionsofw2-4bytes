package app.infrastructure.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.domain.model.InvoiceDetail;
import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.Visit;
import app.infrastructure.persistence.entities.VisitEntity;

public class VisitMapper {

    private static final ObjectMapper om = new ObjectMapper();

    public static Visit toDomain(VisitEntity e) {
        if (e == null) return null;
        Visit v = new Visit();
        v.setVisitId(e.getVisitId());
        if (e.getVisitDate() != null) v.setVisitDate(java.time.LocalDateTime.parse(e.getVisitDate()));
        if (e.getPatientId() != null) { Patient p = new Patient(); p.setId(e.getPatientId()); v.setPatient(p); }
        if (e.getNurseId() != null) { User n = new User(); n.setId(e.getNurseId()); v.setNurse(n); }
        try {
            List<String> meds = e.getMedicationsAdministeredJson() != null ? om.readValue(e.getMedicationsAdministeredJson(), new TypeReference<List<String>>() {}) : new ArrayList<>();
            v.setMedicationsAdministered(meds);
            List<String> procs = e.getProceduresPerformedJson() != null ? om.readValue(e.getProceduresPerformedJson(), new TypeReference<List<String>>() {}) : new ArrayList<>();
            v.setProceduresPerformed(procs);
            List<String> tests = e.getDiagnosticTestsJson() != null ? om.readValue(e.getDiagnosticTestsJson(), new TypeReference<List<String>>() {}) : new ArrayList<>();
            v.setDiagnosticTests(tests);
            List<InvoiceDetail> medDetails = e.getMedicationDetailsJson() != null ? om.readValue(e.getMedicationDetailsJson(), new TypeReference<List<InvoiceDetail>>() {}) : new ArrayList<>();
            v.setMedicationDetails(medDetails);
            List<InvoiceDetail> procDetails = e.getProcedureDetailsJson() != null ? om.readValue(e.getProcedureDetailsJson(), new TypeReference<List<InvoiceDetail>>() {}) : new ArrayList<>();
            v.setProcedureDetails(procDetails);
        } catch (Exception ex) {
            throw new RuntimeException("Error mapping VisitEntity JSON to domain", ex);
        }
        if (e.getRelatedOrderNumber() != null) { MedicalOrder mo = new MedicalOrder(); mo.setOrderNumber(e.getRelatedOrderNumber()); v.setRelatedOrder(mo); }
        return v;
    }

    public static VisitEntity toEntity(Visit v) {
        if (v == null) return null;
        VisitEntity e = new VisitEntity();
        e.setVisitId(v.getVisitId());
        e.setVisitDate(v.getVisitDate() != null ? v.getVisitDate().toString() : null);
        e.setPatientId(v.getPatient() != null ? v.getPatient().getId() : null);
        e.setNurseId(v.getNurse() != null ? v.getNurse().getId() : null);
        try {
            e.setMedicationsAdministeredJson(v.getMedicationsAdministered() != null ? om.writeValueAsString(v.getMedicationsAdministered()) : om.writeValueAsString(new ArrayList<>()));
            e.setProceduresPerformedJson(v.getProceduresPerformed() != null ? om.writeValueAsString(v.getProceduresPerformed()) : om.writeValueAsString(new ArrayList<>()));
            e.setDiagnosticTestsJson(v.getDiagnosticTests() != null ? om.writeValueAsString(v.getDiagnosticTests()) : om.writeValueAsString(new ArrayList<>()));
            e.setMedicationDetailsJson(v.getMedicationDetails() != null ? om.writeValueAsString(v.getMedicationDetails()) : om.writeValueAsString(new ArrayList<>()));
            e.setProcedureDetailsJson(v.getProcedureDetails() != null ? om.writeValueAsString(v.getProcedureDetails()) : om.writeValueAsString(new ArrayList<>()));
        } catch (Exception ex) {
            throw new RuntimeException("Error mapping Visit domain to JSON", ex);
        }
        e.setRelatedOrderNumber(v.getRelatedOrder() != null ? v.getRelatedOrder().getOrderNumber() : null);
        return e;
    }
}
