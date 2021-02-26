package drivercinema.service;

import drivercinema.model.Order;
import drivercinema.model.ShoppingCart;
import drivercinema.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
