package drive_in_cinema.controller;

import drive_in_cinema.dto.mapper.impl.ShoppingCartMapper;
import drive_in_cinema.dto.response.ShoppingCartResponseDto;
import drive_in_cinema.model.ShoppingCart;
import drive_in_cinema.service.MovieSessionService;
import drive_in_cinema.service.ShoppingCartService;
import drive_in_cinema.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ShoppingCartResponseDto getByUserId(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String phoneNumber = userDetails.getUsername();
        ShoppingCart byUser = shoppingCartService.getByUser(userService.findByPhoneNumber(phoneNumber).get());
        return shoppingCartMapper.mapToDto(byUser);
    }

    @PostMapping("/movie-sessions")
    public void addSession(Authentication authentication,
                           @RequestParam Long moviesSessionId) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        shoppingCartService.addSession(movieService.getById(moviesSessionId),
                userService.findByPhoneNumber(email).get());
    }
}
