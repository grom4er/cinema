package drivercinema.dao;

import drivercinema.model.Order;
import drivercinema.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
