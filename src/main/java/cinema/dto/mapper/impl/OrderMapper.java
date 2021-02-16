package cinema.dto.mapper.impl;

import cinema.dto.mapper.ResponseDtoMapper;
import cinema.dto.response.OrderResponseDto;
import cinema.model.Order;
import cinema.model.Ticket;
import cinema.service.OrderService;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    private final OrderService orderService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public OrderMapper(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderTime(order.getOrderDate().format(formatter));
        orderResponseDto.setId(order.getId());
        orderResponseDto.setTicketsId(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setUserEmail(order.getUser().getEmail());
        return orderResponseDto;
    }
}
