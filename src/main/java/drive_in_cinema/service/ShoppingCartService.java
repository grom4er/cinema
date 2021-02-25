package drive_in_cinema.service;

import drive_in_cinema.model.MovieSession;
import drive_in_cinema.model.ShoppingCart;
import drive_in_cinema.model.User;

public interface ShoppingCartService {
    ShoppingCart addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
