package drive_in_cinema.dao.impl;

import drive_in_cinema.dao.LocationDao;
import drive_in_cinema.exception.DataProcessingException;
import drive_in_cinema.model.Location;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDaoImpl implements LocationDao {
    private final SessionFactory sessionFactory;

    public LocationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Location add(Location location) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(location);
            transaction.commit();
            return location;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert location entity " + location, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Location> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Location WHERE id = :id", Location.class)
                    .setParameter("id", id)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get location with id " + id + ".", e);
        }
    }

    @Override
    public List<Location> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Location> getAllCinemaHall
                    = session.createQuery("FROM Location", Location.class);
            return getAllCinemaHall.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a list of locations entities", e);
        }
    }
}
