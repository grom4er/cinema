package cinema.dao.impl;

import cinema.dao.OrderDao;
import cinema.lib.Dao;
import cinema.model.Order;
import cinema.model.ShoppingCart;
import cinema.model.User;
import java.util.List;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return null;
    }
}
