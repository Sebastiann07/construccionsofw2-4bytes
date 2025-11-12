package app.infrastructure.adapter.in.rest.humanresources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.User;
import app.infrastructure.adapter.in.rest.humanresources.request.CreateUserRequest;
import app.infrastructure.adapter.in.rest.humanresources.request.UpdateUserRequest;
import app.infrastructure.adapter.in.rest.humanresources.response.UpdateUserResponse;
import app.infrastructure.adapter.in.rest.humanresources.response.UserResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/hr")
@PreAuthorize("hasRole('HUMANRESOURCES')")
@Validated
public class HumanResourcesController {

    private final HumanResourcesUseCase useCase;

    @Autowired private HRMapper hrMapper;
    @Autowired private HRResponseMapper responseMapper;

    public HumanResourcesController(HumanResourcesUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) throws Exception {
        User user = hrMapper.toUser(request);
        useCase.createUser(user);
        return new ResponseEntity<>(responseMapper.toUserResponse(user), HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<UpdateUserResponse> updateUser(@Valid @RequestBody UpdateUserRequest request) throws Exception {
        User user = hrMapper.toUser(request);
        useCase.updateUser(user);
        return ResponseEntity.ok(responseMapper.toUpdateUserResponse(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("id") long id) throws Exception {
        useCase.deleteUser(id);
        UserResponse resp = new UserResponse();
        resp.setId(id);
        return ResponseEntity.ok(resp);
    }
}
