package drive_in_cinema.service;

import drive_in_cinema.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User getById(Long id);

    Optional<User> findByPhoneNumber(String email);
}
