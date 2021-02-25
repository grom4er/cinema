package drive_in_cinema.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private String userPhoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setPhoneNumber(String userEmail) {
        this.userPhoneNumber = userEmail;
    }
}
