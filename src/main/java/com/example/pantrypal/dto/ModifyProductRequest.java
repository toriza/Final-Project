package com.example.pantrypal.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Getter
@Setter
public class ModifyProductRequest {

        @NotBlank(message = "Name cannot be blank")
        private String name;

        private String description;

        @Positive(message = "Price must be positive")
        private double price;

        @Positive(message = "Quantity must be positive")
        private int quantity;

        private String storingLocation;
}