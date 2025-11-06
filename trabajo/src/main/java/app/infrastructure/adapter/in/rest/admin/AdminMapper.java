package app.infrastructure.adapter.in.rest.admin;

import app.domain.model.*;

public class AdminMapper {

    public Patient toPatient(AdminController.CreatePatientRequest req) { return req.patient; }
    public Patient toPatient(AdminController.UpdatePatientRequest req) { return req.patient; }
    public Invoice toInvoice(AdminController.CreateInvoiceRequest req) { return req.invoice; }
    public EmergencyContact toEmergencyContact(AdminController.CreateEmergencyContactRequest req) { return req.contact; }
    public Insurance toInsurance(AdminController.CreateInsuranceRequest req) { return req.insurance; }
    public Visit toVisit(AdminController.ScheduleVisitRequest req) { return req.visit; }
    public User toUser(AdminController.UpdateUserRequest req) { return req.user; }
}
