package cinema.dto.mapper.impl;

import cinema.dto.mapper.RequestDtoMapper;
import cinema.dto.mapper.ResponseDtoMapper;
import cinema.dto.request.MovieRequestDto;
import cinema.dto.response.MovieResponseDto;
import cinema.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements RequestDtoMapper<MovieRequestDto, Movie>,
        ResponseDtoMapper<MovieResponseDto, Movie> {

    @Override
    public Movie mapToObject(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getMovieTitle());
        movie.setDescription(dto.getMovieDescription());
        return movie;
    }

    @Override
    public MovieResponseDto mapToDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setMovieId(movie.getId());
        responseDto.setMovieTitle(movie.getTitle());
        responseDto.setMovieDescription(movie.getDescription());
        return responseDto;
    }
}
