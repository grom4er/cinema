package cinema.controller;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectController {
    private final RoleService roleService;
    private final UserService userService;

    public InjectController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String inject() {
        Role adminRole = new Role();
        Role userRole = new Role();
        userRole.setRole("user");
        adminRole.setRole("admin");
        roleService.add(adminRole);
        roleService.add(userRole);
        User userAdmin = new User();
        userAdmin.setEmail("admin@gmail.com");
        userAdmin.setPassword("12345");
        userAdmin.setUserRole(List.of(adminRole));
        userService.add(userAdmin);
        return "inject complete";
    }
}
