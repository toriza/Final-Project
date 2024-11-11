package com.example.pantrypal.model;

import java.util.Date;

public class Dairy extends Product {
    private Date expiryDate;
    private Date openedDate;

    public Dairy(String name, String description, double price, int quantity, String storingLocation) {
        super(name, description, price, quantity, storingLocation);
    }
}
