package com.example.deTodoUnPoco.mapper;

import com.example.deTodoUnPoco.DTO.ProductAdminDTO;
import com.example.deTodoUnPoco.DTO.ProductDTO;
import com.example.deTodoUnPoco.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public Product ProductDTOToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setTipe(productDTO.getTipe());
        product.setImage(productDTO.getImage());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return product;
    }

    public ProductDTO ProductToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setTipe(product.getTipe());
        productDTO.setImage(product.getImage());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        return productDTO;
    }

    public ProductAdminDTO ProductAdminToDTO(Product product){
        ProductAdminDTO productDTO = new ProductAdminDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setTipe(product.getTipe());
        productDTO.setImage(product.getImage());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        productDTO.setDeleted(product.isDeleted());
        return productDTO;
    }

    public List<ProductDTO> ListEntityToDTOForUsers(List<Product> products){
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product : products){
            if(product.getStock() > 0) {
                productDTOS.add(this.ProductToDTO(product));
            }
        }
        return productDTOS;
    }

    public List<ProductAdminDTO> ListEntityToDTOForAdmin(List<Product> products){
        List<ProductAdminDTO> productDTOS = new ArrayList<>();
        for(Product product : products){
                productDTOS.add(this.ProductAdminToDTO(product));
        }
        return productDTOS;
    }
}
