package com.example.pantrypal.model;

public class DryProducts extends Product {

    private boolean edible;

    public DryProducts(String name, String description, double price, int quantity, String storingLocation) {
        super(name, description, price, quantity, storingLocation);
    }
}
