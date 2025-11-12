package app.infrastructure.adapter.in.rest.admin.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// DTO de creación de paciente. Se mantienen tipos String para parseo flexible en el mapper.
public class CreatePatientRequest {
    // Opcional: id (generalmente generado por la BD); si se omite creamos paciente sin ID y el builder ya no lo exigirá.
    private String id;

    @NotBlank(message = "fullName es requerido")
    @Size(max = 120, message = "fullName máximo 120 caracteres")
    private String fullName;

    // Fecha en formato ISO (yyyy-MM-dd) o similar; validación simplificada.
    @NotBlank(message = "birthDate es requerido")
    private String birthDate;

    @NotBlank(message = "address es requerido")
    @Size(max = 200, message = "address máximo 200 caracteres")
    private String address;

    @NotBlank(message = "phone es requerido")
    @Size(max = 30, message = "phone máximo 30 caracteres")
    private String phone;

    @NotBlank(message = "email es requerido")
    @Email(message = "email debe tener formato válido")
    private String email;

    // Edad numérica positiva. Se valida con regex para asegurar dígitos.
    @Pattern(regexp = "^\\d+$", message = "age debe ser numérico")
    private String age;

    @NotBlank(message = "gender es requerido")
    private String gender;

    public CreatePatientRequest() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
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
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
