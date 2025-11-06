package app.infrastructure.adapter.in.rest.humanresources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.User;

@RestController
@RequestMapping("/api/hr")
public class HumanResourcesController {

    private final HumanResourcesUseCase useCase;
    private final HRMapper mapper = new HRMapper();

    public HumanResourcesController(HumanResourcesUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) throws Exception {
        User user = mapper.toUser(request);
        useCase.createUser(user);
        return ResponseEntity.ok(new CreateUserResponse("Usuario creado", user));
    }

    @PutMapping("/users")
    public ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest request) throws Exception {
        User user = mapper.toUser(request);
        useCase.updateUser(user);
        return ResponseEntity.ok(new UpdateUserResponse("Usuario actualizado", user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable("id") long id) throws Exception {
        useCase.deleteUser(id);
        return ResponseEntity.ok(new DeleteUserResponse("Usuario eliminado", id));
    }

    public static class CreateUserRequest { public User user; }
    public static class CreateUserResponse { public String message; public User user; public CreateUserResponse(String m, User u){this.message=m;this.user=u;} }

    public static class UpdateUserRequest { public User user; }
    public static class UpdateUserResponse { public String message; public User user; public UpdateUserResponse(String m, User u){this.message=m;this.user=u;} }

    public static class DeleteUserResponse { public String message; public long userId; public DeleteUserResponse(String m, long id){this.message=m;this.userId=id;} }

}
