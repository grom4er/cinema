package drive_in_cinema.controller;

import drive_in_cinema.dto.request.driverRequestDto;
import drive_in_cinema.security.AuthenticationService;
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
    public void register(@RequestBody @Valid driverRequestDto dto) {
        authenticationService.register(dto.phoneNumber(), dto.getPassword());
    }
}
