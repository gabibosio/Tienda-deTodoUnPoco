package com.example.deTodoUnPoco.service;

import com.example.deTodoUnPoco.DTO.ProductDTO;
import com.example.deTodoUnPoco.model.Product;

import java.util.List;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);

    List<ProductDTO> findProducts();

    Product findById(long id);

    ProductDTO editProduct(long id, ProductDTO productDTO);

    void deleteProduct(long id);
}
