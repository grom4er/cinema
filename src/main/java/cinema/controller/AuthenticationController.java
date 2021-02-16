package cinema.controller;

import cinema.dto.mapper.impl.UserMapper;
import cinema.dto.request.UserRequestDto;
import cinema.exception.RegistrationException;
import cinema.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserMapper userMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserMapper userMapper,
                                    AuthenticationService authenticationService) {
        this.userMapper = userMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto dto) {
        try {
            authenticationService.register(dto.getEmail(), dto.getPwd());
        } catch (RegistrationException e) {
            System.err.println("Problem to registration user " + dto);
        }
    }
}
