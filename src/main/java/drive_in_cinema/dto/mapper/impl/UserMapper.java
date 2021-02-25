package drive_in_cinema.dto.mapper.impl;

import drive_in_cinema.dto.mapper.RequestDtoMapper;
import drive_in_cinema.dto.mapper.ResponseDtoMapper;
import drive_in_cinema.dto.request.driverRequestDto;
import drive_in_cinema.dto.response.UserResponseDto;
import drive_in_cinema.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements RequestDtoMapper<driverRequestDto, User>,
        ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public User mapToObject(driverRequestDto requestDto) {
        User user = new User();
        user.setPassword(requestDto.getPassword());
        user.setPhoneNumber(requestDto.phoneNumber());
        return user;
    }

    @Override
    public UserResponseDto mapToDto(User entity) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(entity.getId());
        userResponseDto.setPhoneNumber(entity.getPhoneNumber());
        return userResponseDto;
    }
}
