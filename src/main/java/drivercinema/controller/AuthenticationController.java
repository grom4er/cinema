package drivercinema.controller;

import drivercinema.dto.request.DriverRequestDto;
import drivercinema.security.AuthenticationService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(
            AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid DriverRequestDto dto) {
        authenticationService.register(dto.phoneNumber(), dto.getPassword());
    }
}
