package drivercinema.dto.mapper.impl;

import drivercinema.dto.mapper.RequestDtoMapper;
import drivercinema.dto.mapper.ResponseDtoMapper;
import drivercinema.dto.request.DriverRequestDto;
import drivercinema.dto.response.UserResponseDto;
import drivercinema.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements RequestDtoMapper<DriverRequestDto, User>,
        ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public User mapToObject(DriverRequestDto requestDto) {
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
