package com.example.deTodoUnPoco.service.implement;

import com.example.deTodoUnPoco.DTO.ProductAdminDTO;
import com.example.deTodoUnPoco.DTO.ProductDTO;
import com.example.deTodoUnPoco.mapper.ProductMapper;
import com.example.deTodoUnPoco.model.Product;
import com.example.deTodoUnPoco.repository.ProductRepository;
import com.example.deTodoUnPoco.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = productMapper.ProductDTOToEntity(productDTO);
        Product productSave = productRepository.save(product);
        return productMapper.ProductToDTO(productSave);
    }

    @Override
    public List<ProductDTO> findProductsUser() {
        List<Product> listProducts = productRepository.findAll();
        return productMapper.ListEntityToDTOForUsers(listProducts);
    }

    @Override
    public List<ProductAdminDTO> findProductsAdmin() {
        List<Product> listProducts = productRepository.getAll();
        return productMapper.ListEntityToDTOForAdmin(listProducts);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductDTO editProduct(long id, ProductDTO productDTO) {
        Product product = this.findById(id);
        assert product != null;
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setTipe(productDTO.getTipe());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());
        Product productSave = productRepository.save(product);
        return productMapper.ProductToDTO(productSave);
    }

    @Override
    public void deleteProduct(long id) {
        Product product = this.findById(id);
        productRepository.delete(product);
    }
}
