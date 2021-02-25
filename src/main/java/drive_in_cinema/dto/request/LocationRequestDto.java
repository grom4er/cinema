package drive_in_cinema.dto.request;

import javax.validation.constraints.NotNull;

public class LocationRequestDto {
    @NotNull
    private String description;
    private int capacity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
