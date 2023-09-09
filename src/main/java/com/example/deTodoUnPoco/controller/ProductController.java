package com.example.deTodoUnPoco.controller;

import com.example.deTodoUnPoco.DTO.ProductDTO;
import com.example.deTodoUnPoco.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        productService.create(productDTO);
        return ResponseEntity.accepted().body(productDTO);
    }

    @GetMapping
    public  ResponseEntity<List<ProductDTO>> findProducts(){
        List<ProductDTO> productDTOS = productService.findProducts();
        return ResponseEntity.ok().body(productDTOS);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ProductDTO> editProduct(@PathVariable long id, @RequestBody ProductDTO productDTO){
        try {
            productService.editProduct(id,productDTO);
            return ResponseEntity.ok().body(productDTO);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable long id){
        try{
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
