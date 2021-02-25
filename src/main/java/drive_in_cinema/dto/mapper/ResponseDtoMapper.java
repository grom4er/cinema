package drive_in_cinema.dto.mapper;

public interface ResponseDtoMapper<I, T> {
    I mapToDto(T entity);
}
