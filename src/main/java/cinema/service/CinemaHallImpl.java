package cinema.service;

import cinema.dao.CinemaHallDao;
import cinema.lib.Inject;
import cinema.lib.Service;
import java.util.List;

@Service
public class CinemaHallImpl implements CinemaHall {
    @Inject
   private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHall.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
