package cinema.dao;

import cinema.model.Order;
import cinema.model.ShoppingCart;
import cinema.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order Order);

    List<Order> getOrdersHistory(User user);
}
