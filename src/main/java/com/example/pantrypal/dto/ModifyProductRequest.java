package com.example.pantrypal.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ModifyProductRequest {

        private String name;
        private String description;
        private double price;
        private int quantity;
        private String storingLocation;
}