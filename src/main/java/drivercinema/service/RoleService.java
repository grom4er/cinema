package drivercinema.service;

import drivercinema.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
