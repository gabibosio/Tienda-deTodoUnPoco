package com.example.deTodoUnPoco.service;

import com.example.deTodoUnPoco.DTO.ProductAdminDTO;
import com.example.deTodoUnPoco.DTO.ProductDTO;
import com.example.deTodoUnPoco.model.Product;

import java.util.List;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);

    List<ProductDTO> findProductsUser();

    List<ProductAdminDTO> findProductsAdmin();

    Product findById(long id);

    ProductDTO editProduct(long id, ProductDTO productDTO);

    void deleteProduct(long id);
}
