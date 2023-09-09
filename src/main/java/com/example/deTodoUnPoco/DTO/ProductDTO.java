package com.example.deTodoUnPoco.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;
    private String description;
    private String tipe;
    private String image;
    private int stock;
    private double price;
}
