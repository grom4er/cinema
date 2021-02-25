package drive_in_cinema.service;

import drive_in_cinema.model.Order;
import drive_in_cinema.model.ShoppingCart;
import drive_in_cinema.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
