package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class PersonValidator {

    public String nameValidator(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("El nombre no puede estar vacío");
        }
        return name.trim();
    }

    public String birthDateValidator(String birthDate) throws Exception {
        if (birthDate == null || birthDate.trim().isEmpty()) {
            throw new Exception("La fecha de nacimiento no puede estar vacía");
        }
        return birthDate.trim();
    }

    public String addressValidator(String address) throws Exception {
        if (address == null || address.trim().isEmpty()) {
            throw new Exception("La dirección no puede estar vacía");
        }
        return address.trim();
    }

    public String phoneValidator(String phone) throws Exception {
        if (phone == null || phone.trim().isEmpty()) {
            throw new Exception("El teléfono no puede estar vacío");
        }
        return phone.trim();
    }

    public String emailValidator(String email) throws Exception {
        if (email == null || email.trim().isEmpty()) {
            throw new Exception("El correo no puede estar vacío");
        }
        if (!email.contains("@")) {
            throw new Exception("El correo no es válido");
        }
        return email.trim();
    }

    public int ageValidator(Integer age) throws Exception {
        if (age == null || age < 0) {
            throw new Exception("La edad debe ser un número positivo");
        }
        return age;
    }
}
