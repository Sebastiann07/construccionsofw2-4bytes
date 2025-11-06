package app.adapter.in.builder;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.CopayRecordValidator;
import app.domain.model.CopayRecord;

@Component
public class CopayRecordBuilder {

    @Autowired private CopayRecordValidator validator;

    public CopayRecord create(String patientId, Double copayAmount, LocalDate date) throws Exception {
        String pid = validator.patientIdValidator(patientId);
        double amount = validator.copayAmountValidator(copayAmount);
        LocalDate d = validator.dateValidator(date);

        return new CopayRecord(pid, amount, d);
    }
}
