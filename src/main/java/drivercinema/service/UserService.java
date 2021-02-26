package drivercinema.service;

import drivercinema.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User getById(Long id);

    Optional<User> findByPhoneNumber(String email);
}
