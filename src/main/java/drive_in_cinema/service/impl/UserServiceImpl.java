package drive_in_cinema.service.impl;

import drive_in_cinema.dao.UserDao;
import drive_in_cinema.model.User;
import drive_in_cinema.service.UserService;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User add(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userDao.add(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id).get();
    }

    @Override
    public Optional<User> findByPhoneNumber(String email) {
        return userDao.findByEmail(email);
    }

}
