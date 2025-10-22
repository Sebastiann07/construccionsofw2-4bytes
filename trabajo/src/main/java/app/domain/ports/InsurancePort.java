package app.domain.ports;

import app.domain.model.Insurance;

public interface InsurancePort {
    public void save(Insurance insurance) throws Exception;
    public Insurance findByPolicyNumber(String policyNumber) throws Exception;
}
