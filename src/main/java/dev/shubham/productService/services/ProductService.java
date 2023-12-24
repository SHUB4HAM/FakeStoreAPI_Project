package dev.shubham.productService.services;

import dev.shubham.productService.dtos.GenericProductDto;
import dev.shubham.productService.models.Product;

public interface ProductService {
    public GenericProductDto getProductById(Long id);

}
