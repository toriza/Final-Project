package com.example.pantrypal.model;
//for fresh meat, chicken and fish
import java.util.Date;

public class FreshGoods extends Product {
        private Date expiryDate;
        private Date openedDate;

        public FreshGoods(String name, String description, double price, int quantity, String storingLocation) {
            super(name, description, price, quantity, storingLocation);
        }
}
