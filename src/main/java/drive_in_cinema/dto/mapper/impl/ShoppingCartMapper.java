package drive_in_cinema.dto.mapper.impl;

import drive_in_cinema.dto.mapper.ResponseDtoMapper;
import drive_in_cinema.dto.response.ShoppingCartResponseDto;
import drive_in_cinema.model.ShoppingCart;
import drive_in_cinema.model.Ticket;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper implements ResponseDtoMapper<ShoppingCartResponseDto,
        ShoppingCart> {
    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart entity) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(entity.getId());
        dto.setTicketIds(entity.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        dto.setPhoneNumber(entity.getUser().getPhoneNumber());
        return dto;
    }
}
