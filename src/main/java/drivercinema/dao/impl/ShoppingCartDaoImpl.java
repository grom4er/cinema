package drivercinema.dao.impl;

import drivercinema.dao.ShoppingCartDao;
import drivercinema.exception.DataProcessingException;
import drivercinema.model.ShoppingCart;
import drivercinema.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    private final SessionFactory sessionFactory;

    public ShoppingCartDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
            return shoppingCart;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save Cart into database. "
                    + shoppingCart + ". ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from ShoppingCart sc "
                    + "left join fetch sc.tickets "
                    + "where sc.user = :user", ShoppingCart.class)
                    .setParameter("user", user)
                    .getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find ShoppingCart by driver: "
                    + user + ". ", e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update Shopping cart with id:"
                    + shoppingCart.getId() + ". ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
