package cinema;

import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application {
    private static final Injector injector =
            Injector.getInstance(Application.class.getPackageName());
    private static final MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static final CinemaHallService cinemaHallService = (CinemaHallService) injector
            .getInstance(CinemaHallService.class);
    private static final MovieSessionService movieSessionService = (MovieSessionService) injector
            .getInstance(MovieSessionService.class);

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fruit-Shop");
        movie.setDescription("Horror");
        movie = movieService.add(movie);
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime.now());
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall = cinemaHallService.add(cinemaHall);
        movieSession.setCinemaHall(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);
        movieSessionService.add(movieSession);
        movieSessionService.findAvailableSessions(1L, LocalDate.now()).forEach(System.out::println);
    }
}

