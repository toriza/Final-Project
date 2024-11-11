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

    }

}
