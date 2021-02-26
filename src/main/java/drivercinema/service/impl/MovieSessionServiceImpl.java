package drivercinema.service.impl;

import drivercinema.dao.MovieSessionDao;
import drivercinema.model.MovieSession;
import drivercinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<drivercinema.model.MovieSession> findAvailableSessions(
            Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession update(MovieSession movieSession) {
        return movieSessionDao.update(movieSession);
    }

    @Override
    public void delete(Long id) {
        movieSessionDao.delete(id);
    }

    @Override
    public MovieSession getById(Long id) {
        return movieSessionDao.getById(id).get();
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }
}
