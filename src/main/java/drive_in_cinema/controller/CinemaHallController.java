package drive_in_cinema.controller;

import drive_in_cinema.dto.mapper.impl.LocationMapper;
import drive_in_cinema.dto.request.LocationRequestDto;
import drive_in_cinema.dto.response.LocationResponseDto;
import drive_in_cinema.model.Location;
import drive_in_cinema.service.LocationService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class CinemaHallController {
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    public CinemaHallController(LocationService locationService,
                                LocationMapper locationMapper) {
        this.locationService = locationService;
        this.locationMapper = locationMapper;
    }

    @PostMapping
    public LocationResponseDto add(@RequestBody @Valid LocationRequestDto requestDto) {
        Location location = locationService.add(locationMapper.mapToObject(requestDto));
        return locationMapper.mapToDto(location);
    }

    @GetMapping
    public List<LocationResponseDto> getAll() {
        return locationService.getAll()
                .stream()
                .map(locationMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
