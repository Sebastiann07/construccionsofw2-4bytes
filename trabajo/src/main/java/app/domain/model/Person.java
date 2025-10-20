package app.domain.model;

/**
 * Clase base del dominio que representa a una persona del sistema.
 * Contiene datos generales y se hereda por User y Patient.
 */

public class Person {

    private long id;              // Identificador interno
    private String fullName;      // Nombre completo
    private String birthDate;     // Fecha de nacimiento (por ahora String)
    private String address;       // Dirección de residencia
    private String phone;         // Teléfono de contacto
    private String email;         // Correo electrónico
    private int age;              // Edad calculada o registrada

    //  Constructor
    public Person() {}

    //  Getters y Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}