package cinema.controller;

import cinema.dto.request.UserRequestDto;
import cinema.security.AuthenticationService;
import javax.validation.Valid;
import cinema.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final RoleService roleService;

    public AuthenticationController(
            AuthenticationService authenticationService, RoleService roleService) {
        this.authenticationService = authenticationService;
        this.roleService = roleService;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRequestDto dto) {
        authenticationService.register(dto.getEmail(), dto.getPassword());
    }
}
