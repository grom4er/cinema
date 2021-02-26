package drivercinema.dto.mapper;

public interface ResponseDtoMapper<I, T> {
    I mapToDto(T entity);
}
