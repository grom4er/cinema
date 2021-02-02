package cinema.dao;

import cinema.model.User;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
