package com.e_commerce_app.Service;

import com.e_commerce_app.Dto.CustomerDto;
import com.e_commerce_app.Dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct (ProductDto productDto);
    ProductDto updateProduct (ProductDto productDto,Long productId);
    void deleteProduct (Long productId);
    ProductDto getProduct (Long productId);
    List<ProductDto> getAllProducts ();
}
