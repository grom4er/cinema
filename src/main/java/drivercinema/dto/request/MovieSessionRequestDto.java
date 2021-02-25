package drivercinema.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class MovieSessionRequestDto {
    @Positive
    private Long movieId;
    @Positive
    private Long locationId;
    @NotNull
    private String showTime;

    public Long getMovieId() {
        return movieId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public String getShowTime() {
        return showTime;
    }
}
