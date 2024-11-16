package com.example.pantrypal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "all_products")

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(length = 500)
    private String description;

    @Positive(message = "Price must be positive")
    private Double price;

    @Positive(message = "Quantity must be positive")
    private Integer quantity;
    
    private String storingLocation;


    public Product(String name, String description, Double price, Integer quantity, String storingLocation) {
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