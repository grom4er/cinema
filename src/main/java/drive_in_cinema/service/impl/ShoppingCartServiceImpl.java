package drive_in_cinema.service.impl;

import drive_in_cinema.dao.ShoppingCartDao;
import drive_in_cinema.dao.TicketDao;
import drive_in_cinema.model.MovieSession;
import drive_in_cinema.model.ShoppingCart;
import drive_in_cinema.model.Ticket;
import drive_in_cinema.model.User;
import drive_in_cinema.service.ShoppingCartService;
import java.util.Collections;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final TicketDao ticketDao;
    private final ShoppingCartDao shoppingCartDao;

    public ShoppingCartServiceImpl(TicketDao ticketDao, ShoppingCartDao shoppingCartDao) {
        this.ticketDao = ticketDao;
        this.shoppingCartDao = shoppingCartDao;
    }

    @Override
    public ShoppingCart addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setMovieSession(movieSession);
        ShoppingCart shoppingCart = getByUser(user);
        ticketDao.add(ticket);
        shoppingCart.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setTickets(Collections.emptyList());
        shoppingCartDao.update(shoppingCart);
    }
}
