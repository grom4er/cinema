package drivercinema.dao.impl;

import drivercinema.dao.MovieSessionDao;
import drivercinema.exception.DataProcessingException;
import drivercinema.model.MovieSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {
    private final SessionFactory sessionFactory;

    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<MovieSession> getallmoviesquery = session.createQuery("FROM MovieSession AS ms "
                    + "left join fetch ms.movie "
                    + "left join fetch ms.locations "
                    + "where ms.movie.id =:movie_id "
                    + "and date_format(ms.showTime, '%Y-%m-%d')=:date", MovieSession.class);
            getallmoviesquery.setParameter("movie_id", movieId);
            getallmoviesquery.setParameter("date", DateTimeFormatter.ISO_LOCAL_DATE.format(date));
            return getallmoviesquery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Problem to take movie session with parameters: "
                    + movieId + " at " + date + ".", e);
        }
    }

    @Override
    public MovieSession update(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update movie session "
                    + movieSession + ".", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete FROM MovieSession ms"
                    + " WHERE ms.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete movie session with id " + id + ".", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<MovieSession> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM MovieSession ms WHERE ms.id=:id", MovieSession.class)
                    .setParameter("id", id)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find Movie Session by id " + id + ".", e);
        }
    }

    @Override
    public MovieSession add(MovieSession session) {
        Transaction transaction = null;
        Session sessionHibernate = null;
        try {
            sessionHibernate = sessionFactory.openSession();
            transaction = sessionHibernate.beginTransaction();
            sessionHibernate.save(session);
            transaction.commit();
            return session;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert session entity " + session + ".", e);
        } finally {
            if (sessionHibernate != null) {
                sessionHibernate.close();
            }
        }
    }
}
