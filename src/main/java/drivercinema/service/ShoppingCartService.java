package drivercinema.service;

import drivercinema.model.MovieSession;
import drivercinema.model.ShoppingCart;
import drivercinema.model.User;

public interface ShoppingCartService {
    ShoppingCart addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
