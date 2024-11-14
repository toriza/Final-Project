package com.example.pantrypal.demo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.pantrypal.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.pantrypal.repository.ProductRepository;

import java.util.List;

@Component
@RequiredArgsConstructor

public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        var savedProducts = productRepository.saveAll(List.of(
                new Product("Milk", "Whole", 2.15, 1, "Fridge"),
                new Product("Detergent", "Universal", 5, 1, "Pantry"),
                new Product("Tomato", "Red", 0.5, 3, "Pantry")
        ));

//        roleService.save(new Role("ROLE_USER"));
//        roleService.save(new Role("ROLE_ADMIN"));
//
//        userService.saveUser(new User("John Doe", "john", "1234"));
//        userService.saveUser(new User("James Smith", "james", "1234"));
//        userService.saveUser(new User("Jane Carry", "jane", "1234"));
//        userService.saveUser(new User("Chris Anderson", "chris", "1234"));
//
//        roleService.addRoleToUser("john", "ROLE_USER");
//        roleService.addRoleToUser("james", "ROLE_ADMIN");
//        roleService.addRoleToUser("jane", "ROLE_USER");
//        roleService.addRoleToUser("chris", "ROLE_ADMIN");
//        roleService.addRoleToUser("chris", "ROLE_USER");
    }

}
