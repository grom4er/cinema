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
    public Movie mapToObject(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setTitle(requestDto.getMovieTitle());
        movie.setDescription(requestDto.getMovieDescription());
        return movie;
    }

    @Override
    public MovieResponseDto mapToDto(Movie entity) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setMovieId(entity.getId());
        responseDto.setMovieTitle(entity.getTitle());
        responseDto.setMovieDescription(entity.getDescription());
        return responseDto;
    }
}
