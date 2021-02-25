package drive_in_cinema.service;

import drive_in_cinema.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
