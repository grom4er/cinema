package drive_in_cinema.service;

import drive_in_cinema.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
