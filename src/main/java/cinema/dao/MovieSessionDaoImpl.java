package cinema.dao;

import cinema.exception.DataProcessingException;
import cinema.lib.Dao;
import cinema.model.MovieSession;
import cinema.util.HibernateUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> getallmoviesquery = session.createQuery("FROM MovieSession AS ms "
                    + "left join fetch ms.movie "
                    + "left join fetch ms.cinemaHall "
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
