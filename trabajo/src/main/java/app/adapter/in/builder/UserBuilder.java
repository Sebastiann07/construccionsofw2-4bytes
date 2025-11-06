package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.PersonValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.User;
import app.domain.model.enums.Role;

@Component
public class UserBuilder {

    @Autowired private PersonValidator personValidator;
    @Autowired private UserValidator userValidator;

    public User create(String id,
                       String fullName,
                       String birthDate,
                       String address,
                       String phone,
                       String email,
                       Integer age,
                       String username,
                       String password,
                       String role) throws Exception {

        // Person fields
        String validName = personValidator.nameValidator(fullName);
        String validBirth = personValidator.birthDateValidator(birthDate);
        String validAddress = personValidator.addressValidator(address);
        String validPhone = personValidator.phoneValidator(phone);
        String validEmail = personValidator.emailValidator(email);
        int validAge = personValidator.ageValidator(age);

        // User fields
        String validUsername = userValidator.documentValidator(username);
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("La contraseña es obligatoria");
        }
        String pwd = password.trim();

        Role r;
        try {
            r = Role.valueOf(role == null ? "" : role.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new Exception("Rol inválido: " + role);
        }

        User u = new User();
        if (id != null && !id.trim().isEmpty()) {
            try { u.setId(Long.parseLong(id.trim())); } catch (NumberFormatException ignore) {}
        }
        u.setFullName(validName);
        u.setBirthDate(validBirth);
        u.setAddress(validAddress);
        u.setPhone(validPhone);
        u.setEmail(validEmail);
        u.setAge(validAge);
        u.setUsername(validUsername);
        u.setPassword(pwd);
        u.setRole(r);
        return u;
    }
}
