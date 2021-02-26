package drivercinema.dao;

import drivercinema.model.ShoppingCart;
import drivercinema.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
