package drivercinema.security;

import drivercinema.model.User;

public interface AuthenticationService {

    User register(String email, String password);
}
