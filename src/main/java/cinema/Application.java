package cinema;

import cinema.lib.Injector;
import cinema.model.Movie;
import cinema.service.MovieService;

public class Application {
    private static final Injector injector =
            Injector.getInstance(Application.class.getPackageName());
    private static final MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);

    public static void main(String[] args) {
        movieService.getAll().forEach(System.out::println);
        Movie movie = new Movie();
        movie.setTitle("Fruit-Shop");
        movie = movieService.add(movie);

        movieService.getAll().forEach(System.out::println);

    }
}
