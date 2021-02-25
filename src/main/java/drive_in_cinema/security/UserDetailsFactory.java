package drive_in_cinema.security;

import drive_in_cinema.model.Role;
import drive_in_cinema.model.User;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsFactory {
    public CustomUserDetails create(User user) {
        return new CustomUserDetails(user.getId(), user.getPhoneNumber(),
                user.getPassword(), mapToGrantedAuthority(user.getUserRole()));
    }

    private List<GrantedAuthority> mapToGrantedAuthority(Set<Role> roleList) {
        return roleList.stream()
                .map(x -> new SimpleGrantedAuthority(x.getRole().getName()))
                .collect(Collectors.toList());
    }
}
