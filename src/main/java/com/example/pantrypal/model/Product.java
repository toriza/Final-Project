package com.example.pantrypal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "AllProducts")

public class Product {
    @Id
    @GeneratedValue

    private long id;

    private String name;
    private String description;
    private double price;
    private int quantity;
    private String storingLocation;


    public Product(String name, String description, double price, int quantity, String storingLocation) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.storingLocation = storingLocation;
    }

    public int addQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        }
        return this.quantity;
    }

    public int removeQuantity(int quantity) {
        if (this.quantity < quantity) {
            this.quantity = 0;
        }
        else {
            this.quantity -= quantity;
        }
        return this.quantity;
    }
}