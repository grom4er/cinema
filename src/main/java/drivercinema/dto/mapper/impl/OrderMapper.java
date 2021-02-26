package drivercinema.dto.mapper.impl;

import drivercinema.dto.mapper.ResponseDtoMapper;
import drivercinema.dto.response.OrderResponseDto;
import drivercinema.model.Order;
import drivercinema.model.Ticket;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @Override
    public OrderResponseDto mapToDto(Order entity) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderTime(entity.getOrderDate().format(FORMATTER));
        orderResponseDto.setId(entity.getId());
        orderResponseDto.setTicketIds(entity.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setDriverPhoneNumber(entity.getUser().getPhoneNumber());
        return orderResponseDto;
    }
}
