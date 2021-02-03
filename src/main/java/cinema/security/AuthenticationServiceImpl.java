package cinema.security;

import cinema.exception.AuthenticationException;
import cinema.exception.RegistrationException;
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
        Optional<User> findEmail = userService.findByEmail(email);

        if (findEmail.isEmpty()) {
            throw new AuthenticationException(String.format("email %s not found", email));
        }
        User user = findEmail.get();

        return user;
    }

    @Override
    public User register(String email, String password) throws RegistrationException {
        if (userService.findByEmail(email).isPresent()) {
            throw new RegistrationException("Email " + email
                    + " actually is register. Please choose another.");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.add(user);
        return user;
    }
}
