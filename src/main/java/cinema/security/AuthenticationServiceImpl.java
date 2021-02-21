package cinema.security;

import cinema.model.User;
import cinema.model.Role;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationServiceImpl(ShoppingCartService shoppingCartService,
                                     UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @Override
    public User register(String email, String password, List<Role> roleList) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUserRole(roleList);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
