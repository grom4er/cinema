package drive_in_cinema.security;

import drive_in_cinema.model.User;

public interface AuthenticationService {

    User register(String email, String password);
}
