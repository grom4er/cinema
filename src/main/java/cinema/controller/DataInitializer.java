package cinema.controller;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
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
        Role userRole = new Role();
        userRole.setRole(Role.RoleType.USER);
        adminRole.setRole(Role.RoleType.ADMIN);
        roleService.add(adminRole);
        roleService.add(userRole);
        User userAdmin = new User();
        userAdmin.setEmail("admin@gmail.com");
        userAdmin.setPassword("12345");
        userAdmin.setUserRole(Set.of(adminRole));
        userService.add(userAdmin);
        return "inject complete";
    }
}
