package drive_in_cinema.dao;

import drive_in_cinema.model.Order;
import drive_in_cinema.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
