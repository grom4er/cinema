package drivercinema.controller;

import drivercinema.dto.mapper.impl.OrderMapper;
import drivercinema.dto.response.OrderResponseDto;
import drivercinema.model.Order;
import drivercinema.service.OrderService;
import drivercinema.service.ShoppingCartService;
import drivercinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String phoneNumber = userDetails.getUsername();
        Order order = orderService.completeOrder(shoppingCartService
                .getByUser(userService.findByPhoneNumber(phoneNumber).get()));
        return orderMapper.mapToDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        List<Order> orders = orderService.getOrdersHistory(
                userService.findByPhoneNumber(email).get());
        return orders.stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
