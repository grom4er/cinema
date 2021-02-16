package cinema.controller;

import cinema.dto.mapper.impl.ShoppingCartMapper;
import cinema.dto.response.ShoppingCartResponseDto;
import cinema.model.ShoppingCart;
import cinema.model.Ticket;
import cinema.service.MovieSessionService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final MovieSessionService movieService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  MovieSessionService movieService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.movieService = movieService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        ShoppingCart byUser = shoppingCartService.getByUser(userService.getById(userId));
        return shoppingCartMapper.mapToDto(byUser);
    }

    @PostMapping("/movie-sessions")
    public void addSession(@RequestParam Long userId,
                                       @RequestParam Long moviesSessionId) {
        shoppingCartService.addSession(movieService.getById(moviesSessionId),
                userService.getById(userId));
    }
}
