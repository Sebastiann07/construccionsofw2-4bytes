package app.infrastructure.adapter.in.rest.humanresources;

import org.springframework.stereotype.Component;

import app.domain.model.User;
import app.infrastructure.adapter.in.rest.humanresources.response.UpdateUserResponse;
import app.infrastructure.adapter.in.rest.humanresources.response.UserResponse;

@Component
public class HRResponseMapper {

    public UserResponse toUserResponse(User u) {
        UserResponse r = new UserResponse();
        r.setId(u.getId());
        r.setUsername(u.getUsername());
        r.setRole(u.getRole() == null ? null : u.getRole().name());
        r.setFullName(u.getFullName());
        r.setEmail(u.getEmail());
        r.setPhone(u.getPhone());
        return r;
    }

    public UpdateUserResponse toUpdateUserResponse(User u) {
        UpdateUserResponse r = new UpdateUserResponse();
        r.setId(u.getId());
        r.setUsername(u.getUsername());
        r.setRole(u.getRole() == null ? null : u.getRole().name());
        r.setFullName(u.getFullName());
        r.setEmail(u.getEmail());
        r.setPhone(u.getPhone());
        return r;
    }
}
