package app.infrastructure.persistence.mapper;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.infrastructure.persistence.entities.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity e) {
        if (e == null) return null;
        User u = new User();
        if (e.getId() != null) u.setId(e.getId());
        u.setUsername(e.getUsername());
        u.setPassword(e.getPassword());
        u.setFullName(e.getFullName());
        u.setBirthDate(e.getBirthDate());
        u.setAddress(e.getAddress());
        u.setPhone(e.getPhone());
        u.setEmail(e.getEmail());
        if (e.getAge() != null) u.setAge(e.getAge());
        if (e.getRole() != null) {
            try { u.setRole(Role.valueOf(e.getRole())); } catch (IllegalArgumentException ex) { /* ignore */ }
        }
        return u;
    }

    public static UserEntity toEntity(User u) {
        if (u == null) return null;
        UserEntity e = new UserEntity();
        if (u.getId() != 0) e.setId(u.getId());
        e.setUsername(u.getUsername());
        e.setPassword(u.getPassword());
        e.setFullName(u.getFullName());
        e.setBirthDate(u.getBirthDate());
        e.setAddress(u.getAddress());
        e.setPhone(u.getPhone());
        e.setEmail(u.getEmail());
        e.setAge(u.getAge());
        e.setRole(u.getRole() != null ? u.getRole().name() : null);
        return e;
    }
}
