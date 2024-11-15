package com.example.pantrypal.model;


import java.util.Date;

public class FreshProducts extends Product {
        private Date expiryDate;
        private Date openedDate;

        public FreshProducts(String name, String description, double price, int quantity, String storingLocation) {
            super(name, description, price, quantity, storingLocation);
        }
}

