package cinema.security;

import cinema.model.Role;
import cinema.model.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsFactory {
    public CustomUserDetails create(User user) {
        return new CustomUserDetails(user.getId(), user.getEmail(),
                user.getPassword(), mapToGrantedAuthority(user.getUserRole()));
    }

    private List<GrantedAuthority> mapToGrantedAuthority(List<Role> roleList) {
        return roleList.stream()
                .map(x -> new SimpleGrantedAuthority(x.getRole()))
                .collect(Collectors.toList());
    }
}
