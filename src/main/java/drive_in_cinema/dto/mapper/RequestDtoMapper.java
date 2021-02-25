package drive_in_cinema.dto.mapper;

public interface RequestDtoMapper<T, I> {
    I mapToObject(T requestDto);
}
