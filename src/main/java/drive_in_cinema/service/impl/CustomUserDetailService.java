package drive_in_cinema.service.impl;

import drive_in_cinema.model.User;
import drive_in_cinema.security.UserDetailsFactory;
import drive_in_cinema.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService
                = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = userService.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with phone number %s not found.", phoneNumber)));
        return new UserDetailsFactory().create(user);
    }

}
