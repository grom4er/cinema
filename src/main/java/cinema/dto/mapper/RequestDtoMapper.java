package cinema.dto.mapper;

public interface RequestDtoMapper<T, I> {
    I mapToObject(T entity);

}
