package cinema.dto.mapper;

public interface ResponseDtoMapper<I, T> {
    I mapToDto(T i);
}
