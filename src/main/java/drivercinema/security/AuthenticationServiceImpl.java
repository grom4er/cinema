package drivercinema.security;

import drivercinema.model.User;
import drivercinema.service.RoleService;
import drivercinema.service.ShoppingCartService;
import drivercinema.service.UserService;
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
