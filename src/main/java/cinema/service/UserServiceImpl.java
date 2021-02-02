package cinema.service;

import cinema.dao.MovieSessionDao;
import cinema.dao.UserDao;
import cinema.lib.Inject;
import cinema.lib.Service;
import cinema.model.User;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;
    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}