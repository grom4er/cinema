package cinema.dto.mapper.impl;

import cinema.dto.mapper.ResponseDtoMapper;
import cinema.dto.response.ShoppingCartResponseDto;
import cinema.model.ShoppingCart;
import cinema.model.Ticket;
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
        dto.setUserEmail(entity.getUser().getEmail());
        return dto;
    }
}
