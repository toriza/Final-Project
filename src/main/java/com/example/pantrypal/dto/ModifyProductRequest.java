package com.example.pantrypal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.Date;


@Getter
@Setter
public class ModifyProductRequest {

        @NotBlank(message = "Name cannot be blank")
        private String name;

        private String description;

        @Positive(message = "Price must be positive")
        private Double price;

        @NotNull(message = "Quantity cannot be null")
        @Positive(message = "Quantity must be positive")
        private Integer quantity;

        private String storingLocation;

        private Date expiryDate;
        private Date openedDate;

        private Boolean edible;
}