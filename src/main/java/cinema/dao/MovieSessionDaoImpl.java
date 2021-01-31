package cinema.dao;

import cinema.exception.DataProcessingException;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.util.HibernateUtil;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> getAllMoviesQuery = session.createQuery("FROM MovieSession as mv" +
                    "INSERT Movie as m " +
                    "INSERT CinemaHall" +
                    "", MovieSession.class);
            return getAllMoviesQuery.getResultList();

    }

    @Override
    public MovieSession add(MovieSession session) {
        Transaction transaction = null;
        Session sessionHibernate = null;
        try {
            sessionHibernate = HibernateUtil.getSessionFactory().openSession();
            transaction = sessionHibernate.beginTransaction();
            sessionHibernate.save(session);
            transaction.commit();
            return session;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert session entity " + session, e);
        } finally {
            if (sessionHibernate != null) {
                sessionHibernate.close();
            }
        }
    }
}
