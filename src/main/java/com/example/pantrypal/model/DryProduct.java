package com.example.pantrypal.model;

import jakarta.persistence.Entity;

@Entity

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


    public String getEdibilityStatus() {
        return edible != null && edible ? "Dry Food" : "Household items";
    }

    public Boolean getEdible() {
        return edible;
    }

    public void setEdible(Boolean edible) {
        this.edible = edible;
    }
}
