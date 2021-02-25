package drive_in_cinema.service.impl;

import drive_in_cinema.dao.OrderDao;
import drive_in_cinema.model.Order;
import drive_in_cinema.model.ShoppingCart;
import drive_in_cinema.model.User;
import drive_in_cinema.service.OrderService;
import drive_in_cinema.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setUser(shoppingCart.getUser());
        order.setOrderDate(LocalDateTime.now());
        order.setTickets(shoppingCart.getTickets());
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
