package cinema.security;

import static cinema.util.HashUtil.hashPassword;

import cinema.exception.AuthenticationException;
import cinema.lib.Inject;
import cinema.lib.Service;
import cinema.model.User;
import cinema.service.UserService;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

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
        return user;
    }
}
