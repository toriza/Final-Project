package com.example.pantrypal.demo;

import com.example.pantrypal.model.Role;
import com.example.pantrypal.model.User;
import com.example.pantrypal.service.RoleService;
import com.example.pantrypal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRoleDataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_USER"));

        userService.saveUser(new User("Admin", "admin", "4321"));
        userService.saveUser(new User("James", "james", "1234"));


        roleService.addRoleToUser("admin", "ROLE_ADMIN");
        roleService.addRoleToUser("james", "ROLE_USER");
    }
}
