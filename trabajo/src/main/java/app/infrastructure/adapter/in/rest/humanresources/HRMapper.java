package app.infrastructure.adapter.in.rest.humanresources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.UserBuilder;
import app.domain.model.User;
import app.infrastructure.adapter.in.rest.humanresources.request.CreateUserRequest;
import app.infrastructure.adapter.in.rest.humanresources.request.UpdateUserRequest;

@Component
public class HRMapper {

    @Autowired private UserBuilder userBuilder;

    public User toUser(CreateUserRequest r) throws Exception {
        Integer age = parseInteger(r.getAge());
        return userBuilder.create(
                null,
                r.getFullName(),
                r.getBirthDate(),
                r.getAddress(),
                r.getPhone(),
                r.getEmail(),
                age,
                r.getUsername(),
                r.getPassword(),
                r.getRole()
        );
    }

    public User toUser(UpdateUserRequest r) throws Exception {
        Integer age = parseInteger(r.getAge());
        return userBuilder.create(
                r.getId(),
                r.getFullName(),
                r.getBirthDate(),
                r.getAddress(),
                r.getPhone(),
                r.getEmail(),
                age,
                r.getUsername(),
                r.getPassword(),
                r.getRole()
        );
    }

    private Integer parseInteger(String v) { if (v == null || v.isBlank()) return null; return Integer.parseInt(v.trim()); }
}
