package cinema;

import cinema.exception.AuthenticationException;
import cinema.exception.RegistrationException;
import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.User;
import cinema.security.AuthenticationService;
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
    private static final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);

    public static void main(String[] args) throws RegistrationException, AuthenticationException {
        //   testMovieCinemaHallSession();
      //  testUserAndAuthentication();
    }

    public static void testMovieCinemaHallSession() {
        Movie movie = new Movie();
        movie.setTitle("Fruit-Shop");
        movie.setDescription("Horror");
        movie = movieService.add(movie);
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime.of(2021, 02, 1, 15, 5));
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall = cinemaHallService.add(cinemaHall);
        movieSession.setCinemaHall(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);
        movieSessionService.add(movieSession);
        movieSessionService.findAvailableSessions(movie.getId(),
                LocalDate.now()).forEach(System.out::println);
    }

    public static void testUserAndAuthentication()
            throws RegistrationException, AuthenticationException {
        User user = new User();
        user.setEmail("tutut@gmal.com");
        user.setPassword("123");
        authenticationService.register(user.getEmail(), user.getPassword());
        authenticationService.login(user.getEmail(), user.getPassword());
        //  authenticationService.login(user.getEmail(),"1222");
    }
}
