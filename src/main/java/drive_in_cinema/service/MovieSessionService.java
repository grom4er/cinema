package drive_in_cinema.service;

import drive_in_cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession update(MovieSession movieSession);

    void delete(Long id);

    MovieSession getById(Long id);

    MovieSession add(MovieSession session);
}
