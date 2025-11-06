package app.infrastructure.adapter.in.rest.humanresources;

import app.domain.model.User;

public class HRMapper {
    public User toUser(HumanResourcesController.CreateUserRequest req) { return req.user; }
    public User toUser(HumanResourcesController.UpdateUserRequest req) { return req.user; }
}
