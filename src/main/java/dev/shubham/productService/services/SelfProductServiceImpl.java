package dev.shubham.productService.services;

import dev.shubham.productService.dtos.GenericProductDto;
import dev.shubham.productService.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductService")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
}
