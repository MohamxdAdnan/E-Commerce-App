package com.e_commerce_app.Controller;

import com.e_commerce_app.Dto.ProductDto;
import com.e_commerce_app.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
}
