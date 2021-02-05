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
import cinema.service.OrderService;
import cinema.service.ShoppingCartService;
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
    private static final ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private static final OrderService orderService =
            (OrderService) injector.getInstance(OrderService.class);

    public static void main(String[] args) throws RegistrationException, AuthenticationException {
        testMovieCinemaHallSession();
        testUserAndAuthentication();
        testCartService();
        testOrder();
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
        System.out.println(authenticationService.login(user.getEmail(), user.getPassword()));
    }

    public static void testCartService() throws RegistrationException {
        User user = new User();
        user.setEmail("adriano@gmail.com");
        user.setPassword("123");
        user = authenticationService.register(user.getEmail(), user.getPassword());
        Movie movie = new Movie();
        movie.setTitle("Hibernate");
        movie.setDescription("Fantastic");
        movie = movieService.add(movie);
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall = cinemaHallService.add(cinemaHall);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.of(2021, 02, 3, 20, 5));
        movieSessionService.add(movieSession);
        shoppingCartService.addSession(movieSession, user);
        System.out.println(shoppingCartService.getByUser(user));
    }

    public static void testOrder() throws RegistrationException {
        User user = new User();
        user.setEmail("tustur@gmail.com");
        user.setPassword("123");
        user = authenticationService.register(user.getEmail(), user.getPassword());
        Movie movie = new Movie();
        movie.setTitle("Windows");
        movie.setDescription("Windowsss");
        movieService.add(movie);
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHallService.add(cinemaHall);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.of(2021, 02, 3, 20, 5));
        movieSessionService.add(movieSession);
        shoppingCartService.addSession(movieSession, user);
        shoppingCartService.addSession(movieSession, user);
        System.out.println(shoppingCartService.getByUser(user));
        System.out.println(orderService.getOrdersHistory(user));
        System.out.println(orderService.completeOrder(shoppingCartService.getByUser(user)));
        System.out.println(orderService.getOrdersHistory(user));
    }
}
