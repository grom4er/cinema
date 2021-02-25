package drive_in_cinema.controller;

import drive_in_cinema.dto.mapper.impl.UserMapper;
import drive_in_cinema.dto.response.UserResponseDto;
import drive_in_cinema.model.User;
import drive_in_cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        User user = userService.findByPhoneNumber(email).get();
        return userMapper.mapToDto(user);
    }
}
