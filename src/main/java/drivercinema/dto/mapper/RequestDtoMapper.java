package drivercinema.dto.mapper;

public interface RequestDtoMapper<T, I> {
    I mapToObject(T requestDto);
}
