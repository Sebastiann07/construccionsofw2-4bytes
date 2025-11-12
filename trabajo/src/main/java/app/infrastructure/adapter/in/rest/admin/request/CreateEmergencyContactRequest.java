package app.infrastructure.adapter.in.rest.admin.request;

public class CreateEmergencyContactRequest {
    private String name;
    private String phone;
    private String relation;

    public CreateEmergencyContactRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }
}
