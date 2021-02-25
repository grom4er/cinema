package drive_in_cinema.dao;

import drive_in_cinema.model.Location;
import java.util.List;
import java.util.Optional;

public interface LocationDao {
    Location add(Location location);

    Optional<Location> get(Long id);

    List<Location> getAll();
}
