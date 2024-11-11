package com.example.pantrypal.model;
//Functionality:
//        Add products to pantry: Add a product to the pantry when it's bought or added.
//        Remove products from pantry: Remove products that are used up or expired.
//        View products: List all products currently in the pantry.
//        Check stock levels: Check the current quantity of a specific product.
//        Expiration management: Identify products that have expired and potentially remove them
//        or flag them for the user.
//        Product categorization: Filter products by categories (e.g., Dairy, Dry Products, etc.).
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class Pantry {

    @OneToMany(mappedBy = "pantry")
    private List<Product> products = new ArrayList<>();
}
