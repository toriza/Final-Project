package com.example.pantrypal.model;

public class DryProduct extends Product {

    private boolean edible;

    public DryProduct(String name, String description, double price, int quantity, String storingLocation) {
        super(name, description, price, quantity, storingLocation);
    }
}
