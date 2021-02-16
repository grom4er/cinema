package cinema.dto.mapper.impl;

import cinema.dto.mapper.RequestDtoMapper;
import cinema.dto.mapper.ResponseDtoMapper;
import cinema.dto.request.CinemaHallRequestDto;
import cinema.dto.response.CinemaHallResponseDto;
import cinema.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper implements RequestDtoMapper<CinemaHallRequestDto, CinemaHall>,
        ResponseDtoMapper<CinemaHallResponseDto, CinemaHall> {

    @Override
    public CinemaHall mapToObject(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(requestDto.getDescription());
        cinemaHall.setCapacity(requestDto.getCapacity());
        return cinemaHall;
    }

    @Override
    public CinemaHallResponseDto mapToDto(CinemaHall entity) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setDescription(entity.getDescription());
        return responseDto;
    }
}
