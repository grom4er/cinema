package drive_in_cinema.dao;

import drive_in_cinema.model.ShoppingCart;
import drive_in_cinema.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
