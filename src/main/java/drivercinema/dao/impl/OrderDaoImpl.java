package drivercinema.dao.impl;

import drivercinema.dao.OrderDao;
import drivercinema.exception.DataProcessingException;
import drivercinema.model.Order;
import drivercinema.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    private final SessionFactory sessionFactory;

    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save order: "
                    + order + " item. ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT distinct o from Order o "
                    + "join fetch o.tickets "
                    + "where o.user = :user", Order.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't take order from driver:"
                    + user + ".", e);
        }
    }
}
