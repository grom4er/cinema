package cinema.service.impl;

import cinema.dao.OrderDao;
import cinema.lib.Inject;
import cinema.lib.Service;
import cinema.model.Order;
import cinema.model.ShoppingCart;
import cinema.model.User;
import cinema.service.OrderService;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
