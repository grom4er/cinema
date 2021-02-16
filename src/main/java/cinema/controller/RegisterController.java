package cinema.controller;

import cinema.dto.mapper.impl.UserMapper;
import cinema.dto.request.UserRequestDto;
import cinema.exception.RegistrationException;
import cinema.security.AuthenticationService;
import cinema.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RegisterController {
    private final UserMapper userMapper;
    private final AuthenticationService authenticationService;

    public RegisterController(UserMapper userMapper, AuthenticationService authenticationService) {
        this.userMapper = userMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto dto) throws RegistrationException {
        authenticationService.register(userMapper.mapToObject(dto).getEmail(),
                userMapper.mapToObject(dto).getPassword());
    }
}
