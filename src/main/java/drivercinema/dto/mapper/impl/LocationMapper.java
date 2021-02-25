package drivercinema.dto.mapper.impl;

import drivercinema.dto.mapper.RequestDtoMapper;
import drivercinema.dto.mapper.ResponseDtoMapper;
import drivercinema.dto.request.LocationRequestDto;
import drivercinema.dto.response.LocationResponseDto;
import drivercinema.model.Location;
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
