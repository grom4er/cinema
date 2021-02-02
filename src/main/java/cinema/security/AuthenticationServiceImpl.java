package cinema.security;

import cinema.exception.AuthenticationException;
import cinema.exception.RegistrationException;
import cinema.model.User;

public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public User login(String email, String password) throws AuthenticationException {
        return null;
    }

    @Override
    public User register(String email, String password) throws RegistrationException {
        return null;
    }
}
