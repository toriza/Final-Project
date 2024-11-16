package com.example.pantrypal.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class DryProduct extends Product {

    private Boolean edible;

    public DryProduct() {
        super();
    }

    public DryProduct(String name, String description, Double price, Integer quantity, String storingLocation,
                      Boolean edible) {
        super(name, description, price, quantity, storingLocation);
        this.edible = edible;
    }

}
