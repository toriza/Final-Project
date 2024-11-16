package com.example.pantrypal.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class FreshProduct extends Product {
    private Date expiryDate;

//    private Date openedDate;

    public FreshProduct(String name, String description, Double price, Integer quantity, String storingLocation,
                        Date expiryDate /*, Date openedDate*/) {
        super(name, description, price, quantity, storingLocation);
        this.expiryDate = expiryDate;
//        this.openedDate = openedDate;
    }

    public boolean isExpired() {
        if (expiryDate == null) return false;
        return expiryDate.before(new Date());
    }
}

