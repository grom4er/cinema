package drivercinema.dao.impl;

import drivercinema.dao.UserDao;
import drivercinema.exception.DataProcessingException;
import drivercinema.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User add(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add user: " + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User u"
                    + "JOIN FETCH u.roles where WHERE u.id=:id", User.class)
                    .setParameter("id", id)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find driver by id " + id + ".", e);
        }
    }

    @Override
    public Optional<User> findByEmail(String phoneNumber) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User u "
                    + "JOIN FETCH u.roles where u.phoneNumber =:phoneNumber", User.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find user by phoneNumber "
                    + phoneNumber + ". ", e);
        }
    }
}
