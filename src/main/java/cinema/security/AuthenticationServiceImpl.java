package cinema.security;

import static cinema.util.HashUtil.hashPassword;

import cinema.exception.AuthenticationException;
import cinema.model.User;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.Optional;
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
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> findUser = userService.findByEmail(email);
        if (findUser.isEmpty() || !hashPassword(password, findUser.get().getSalt())
                .equals(findUser.get().getPassword())) {
            throw new AuthenticationException("email or password wrong");
        }
        return findUser.get();
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
