package drive_in_cinema.service.impl;

import drive_in_cinema.dao.LocationDao;
import drive_in_cinema.exception.DataProcessingException;
import drive_in_cinema.model.Location;
import drive_in_cinema.service.LocationService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationDao locationDao;

    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public Location add(Location location) {
        return locationDao.add(location);
    }

    @Override
    public Location get(Long id) {
        return locationDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get location by id " + id + "."));
    }

    @Override
    public List<Location> getAll() {
        return locationDao.getAll();
    }
}
