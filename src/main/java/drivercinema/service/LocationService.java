package drivercinema.service;

import drivercinema.model.Location;
import java.util.List;

public interface LocationService {
    Location add(Location location);

    Location get(Long id);

    List<Location> getAll();
}
