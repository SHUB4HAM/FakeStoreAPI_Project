package dev.shubham.productService.controllers;

import dev.shubham.productService.dtos.GenericProductDto;
import dev.shubham.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;


    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public void getAllProducts() {
    }
    // localhost:8080/products/1
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById() {
    }
    @PostMapping
    public void createProduct() {
    }
    @PutMapping("/{id}")
    public void updateProduct() {
    }

}
