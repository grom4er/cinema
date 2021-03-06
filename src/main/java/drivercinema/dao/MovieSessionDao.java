package drivercinema.dao;

import drivercinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession update(MovieSession movieSession);

    void delete(Long id);

    Optional<MovieSession> getById(Long id);

    MovieSession add(MovieSession session);
}
