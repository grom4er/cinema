package drivercinema.dao;

import drivercinema.model.Location;
import java.util.List;
import java.util.Optional;

public interface LocationDao {
    Location add(Location location);

    Optional<Location> get(Long id);

    List<Location> getAll();
}
