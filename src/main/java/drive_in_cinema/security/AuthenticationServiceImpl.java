package drive_in_cinema.security;

import drive_in_cinema.model.User;
import drive_in_cinema.service.RoleService;
import drive_in_cinema.service.ShoppingCartService;
import drive_in_cinema.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(ShoppingCartService shoppingCartService,
                                     UserService userService, RoleService roleService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setPhoneNumber(email);
        user.setPassword(password);
        user.setUserRole(Set.of(roleService.getRoleByName("DRIVER")));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
