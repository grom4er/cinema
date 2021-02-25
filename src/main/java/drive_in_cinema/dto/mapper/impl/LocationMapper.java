package drive_in_cinema.dto.mapper.impl;

import drive_in_cinema.dto.mapper.RequestDtoMapper;
import drive_in_cinema.dto.mapper.ResponseDtoMapper;
import drive_in_cinema.dto.request.LocationRequestDto;
import drive_in_cinema.dto.response.LocationResponseDto;
import drive_in_cinema.model.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper implements RequestDtoMapper<LocationRequestDto, Location>,
        ResponseDtoMapper<LocationResponseDto, Location> {

    @Override
    public Location mapToObject(LocationRequestDto requestDto) {
        Location location = new Location();
        location.setDescription(requestDto.getDescription());
        location.setCapacity(requestDto.getCapacity());
        return location;
    }

    @Override
    public LocationResponseDto mapToDto(Location entity) {
        LocationResponseDto responseDto = new LocationResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setCapacity(entity.getCapacity());
        responseDto.setDescription(entity.getDescription());
        return responseDto;
    }
}
