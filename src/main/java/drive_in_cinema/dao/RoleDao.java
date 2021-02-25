package drive_in_cinema.dao;

import drive_in_cinema.model.Role;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
