package com.example.deTodoUnPoco.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAdminDTO {

    private long id;
    private String name;
    private String description;
    private String tipe;
    private String image;
    private int stock;
    private double price;
    private boolean deleted;
}
