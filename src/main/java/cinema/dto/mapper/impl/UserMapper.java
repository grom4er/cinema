package cinema.dto.mapper.impl;

import cinema.dto.mapper.RequestDtoMapper;
import cinema.dto.mapper.ResponseDtoMapper;
import cinema.dto.request.UserRequestDto;
import cinema.dto.response.UserResponseDto;
import cinema.model.User;
import cinema.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements RequestDtoMapper<UserRequestDto, User>,
        ResponseDtoMapper<UserResponseDto, User> {
    private final UserService userService;

    public UserMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User mapToObject(UserRequestDto entity) {
        User user = new User();
        user.setPassword(entity.getPwd());
        user.setEmail(entity.getEmail());
        return user;
    }

    @Override
    public UserResponseDto mapToDto(User entity) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(entity.getId());
        userResponseDto.setEmail(entity.getEmail());
        return userResponseDto;
    }
}
