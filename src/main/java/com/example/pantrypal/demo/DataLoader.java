package com.example.pantrypal.demo;

import com.example.pantrypal.model.FreshProduct;
import com.example.pantrypal.model.DryProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.pantrypal.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.pantrypal.repository.ProductRepository;


import java.text.SimpleDateFormat;
import java.util.List;

@Component
@RequiredArgsConstructor

public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        var savedProducts = productRepository.saveAll(List.of(
                new FreshProduct("Milk", "Whole", 2.15, 1, "Fridge", dateFormat.parse("2024-11-14")),
                new DryProduct("Detergent", "Universal", 5.79, 950, "Pantry", false),
                new FreshProduct("Tomato", "A ripe tomato", 2.5, 10, "Pantry", dateFormat.parse("2024-11-20")),
                new FreshProduct("Banana", "Yellow", 1.2, 5, "Pantry", dateFormat.parse("2024-11-26")),
                new DryProduct("Rice", "Long grain rice", 1.99, 250, "Pantry", true),
                new DryProduct("Paper towels", "Two layers", 2.49, 100, "Pantry", false),
                new FreshProduct("Strawberries", "Sweet", 5.2, 180, "Fridge", dateFormat.parse("2024-11-12"))
                ));
    }

}
