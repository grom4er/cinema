package drivercinema.controller;

import drivercinema.model.Role;
import drivercinema.model.User;
import drivercinema.service.RoleService;
import drivercinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public String inject() {
        Role adminRole = new Role();
        Role driverRole = new Role();
        driverRole.setRole(Role.RoleType.DRIVER);
        adminRole.setRole(Role.RoleType.ADMIN);
        roleService.add(adminRole);
        roleService.add(driverRole);
        User userAdmin = new User();
        userAdmin.setPhoneNumber("+380934328100");
        userAdmin.setPassword("12345");
        userAdmin.setUserRole(Set.of(adminRole));
        userService.add(userAdmin);
        return "inject complete";
    }
}
