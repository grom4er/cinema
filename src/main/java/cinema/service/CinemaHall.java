package cinema.service;

import java.util.List;

public interface CinemaHall {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
