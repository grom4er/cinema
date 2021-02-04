package cinema.service.impl;

import cinema.lib.Service;
import cinema.model.Order;
import cinema.model.ShoppingCart;
import cinema.model.User;
import cinema.service.OrderService;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return null;
    }
}
