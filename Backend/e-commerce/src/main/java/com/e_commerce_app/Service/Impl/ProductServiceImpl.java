package com.e_commerce_app.Service.Impl;

import com.e_commerce_app.Dto.ProductDto;
import com.e_commerce_app.Entity.Product;
import com.e_commerce_app.Exception.ResourceNotFoundException;
import com.e_commerce_app.Repository.ProductRepository;
import com.e_commerce_app.Service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product=modelMapper.map(productDto,Product.class);
        Product newProduct = productRepository.save(product);
        return modelMapper.map(newProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long productId) {
        Product product=productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product Not Found with ID : " + productId));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategoryId(productDto.getCategoryId());

        Product newProduct = productRepository.save(product);
        return modelMapper.map(newProduct,ProductDto.class);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product=productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product Not Found with ID : " + productId));
        productRepository.delete(product);
    }

    @Override
    public ProductDto getProduct(Long productId) {
        Product product=productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product Not Found with ID : " + productId));

        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> allProductDtos = allProducts.stream()
                .map((product)-> modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
        return allProductDtos;
    }
}
