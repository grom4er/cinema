package drive_in_cinema.dto.mapper.impl;

import drive_in_cinema.dto.mapper.RequestDtoMapper;
import drive_in_cinema.dto.mapper.ResponseDtoMapper;
import drive_in_cinema.dto.request.MovieSessionRequestDto;
import drive_in_cinema.dto.response.MovieSessionResponseDto;
import drive_in_cinema.model.MovieSession;
import drive_in_cinema.service.LocationService;
import drive_in_cinema.service.MovieService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper implements RequestDtoMapper<MovieSessionRequestDto, MovieSession>,
        ResponseDtoMapper<MovieSessionResponseDto, MovieSession> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final LocationService locationService;
    private final MovieService movieService;

    public MovieSessionMapper(LocationService locationService, MovieService movieService) {
        this.locationService = locationService;
        this.movieService = movieService;
    }

    @Override
    public MovieSessionResponseDto mapToDto(MovieSession entity) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setMovieSessionId(entity.getId());
        responseDto.setLocationId(entity.getLocation().getId());
        responseDto.setMovieId(entity.getMovie().getId());
        responseDto.setMovieTitle(entity.getMovie().getTitle());
        responseDto.setShowTime(entity.getShowTime().format(formatter));
        return responseDto;
    }

    @Override
    public MovieSession mapToObject(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setLocation(locationService.get(requestDto.getLocationId()));
        movieSession.setShowTime(LocalDateTime.parse(requestDto.getShowTime(), formatter));
        return movieSession;
    }
}
