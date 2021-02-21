package cinema.security;

import cinema.model.User;
import cinema.model.UserRole;
import java.util.List;

public interface AuthenticationService {

    User register(String email, String password, List<UserRole> roleList);
}
