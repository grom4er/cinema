package cinema.security;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.ArrayList;
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
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Role role = new Role();
        role.setRole("user");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        user.setUserRole(roleList);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
