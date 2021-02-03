package cinema.service;

import cinema.dao.UserDao;
import cinema.lib.Inject;
import cinema.lib.Service;
import cinema.model.User;
import cinema.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        String password = user.getPassword();
        byte[] salt = HashUtil.getSalt();
        String hashedPassword = HashUtil.hashPassword(password, salt);
        user.setPassword(hashedPassword);
        user.setSalt(salt);
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
