package drivercinema.service.impl;

import drivercinema.dao.LocationDao;
import drivercinema.exception.DataProcessingException;
import drivercinema.model.Location;
import drivercinema.service.LocationService;
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
