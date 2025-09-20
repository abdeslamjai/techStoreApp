package com.app.techStoreApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.Year;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Product cannot be null")
    private ProductType productType;

    @NotBlank(message = "brand cannot be null")
    private String brand;

    @NotBlank(message = "model cannot be null")
    private String model;

    @NotNull(message = "price cannot be null")
    @Positive
    private Double price;

    @NotNull(message = "price cannot be null")
    private Year year;

}
