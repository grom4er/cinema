package drive_in_cinema.service;

import drive_in_cinema.model.Location;
import java.util.List;

public interface LocationService {
    Location add(Location location);

    Location get(Long id);

    List<Location> getAll();
}
