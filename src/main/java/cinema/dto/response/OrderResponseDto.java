package cinema.dto.response;

import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private String orderTime;
    private String userEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
