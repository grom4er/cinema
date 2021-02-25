package drive_in_cinema.controller;

import drive_in_cinema.model.Role;
import drive_in_cinema.model.User;
import drive_in_cinema.service.RoleService;
import drive_in_cinema.service.UserService;
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
        userAdmin.setPhoneNumber("admin@gmail.com");
        userAdmin.setPassword("12345");
        userAdmin.setUserRole(Set.of(adminRole));
        userService.add(userAdmin);
        return "inject complete";
    }
}
