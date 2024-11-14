package com.example.pantrypal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "AllProducts")


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(length = 500)
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

    public int reduceQuantity(int quantity) {
        if (this.quantity < quantity) {
            this.quantity = 0;
        }
        else {
            this.quantity -= quantity;
        }
        return this.quantity;
    }
}