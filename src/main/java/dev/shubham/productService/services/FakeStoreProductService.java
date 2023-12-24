package dev.shubham.productService.services;

import dev.shubham.productService.dtos.FakeStoreProductDto;
import dev.shubham.productService.dtos.GenericProductDto;
import dev.shubham.productService.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
        private RestTemplateBuilder restTemplateBuilder;
        private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
        public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
            this.restTemplateBuilder = restTemplateBuilder;
        }
        @Override
        public GenericProductDto getProductById(Long id) {
            RestTemplate restTemplate = restTemplateBuilder.build();
            ResponseEntity<FakeStoreProductDto> response =
                    restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);

            FakeStoreProductDto fakeStoreProductDto = response.getBody();
            GenericProductDto product = new GenericProductDto();
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setCategory(fakeStoreProductDto.getCategory());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImage(fakeStoreProductDto.getImage());

            return product;
        }
}