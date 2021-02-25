package drivercinema.dto.mapper.impl;

import drivercinema.dto.mapper.ResponseDtoMapper;
import drivercinema.dto.response.ShoppingCartResponseDto;
import drivercinema.model.ShoppingCart;
import drivercinema.model.Ticket;
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
