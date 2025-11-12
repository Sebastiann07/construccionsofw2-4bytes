package app.infrastructure.adapter.in.rest.admin.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    private String fullName;
    private String birthDate;
    private String address;
    private String phone;
    @Email private String email;
    private String age;
    private String username;
    @Size(min = 6) private String password;

    public CreateUserRequest() {}

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
