package com.e_commerce_app.Controller;

import com.e_commerce_app.Dto.ProductDto;
import com.e_commerce_app.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        ProductDto productDto = productService.getProduct(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted", HttpStatus.NO_CONTENT);
    }
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id) {
        ProductDto updatedProduct = productService.updateProduct(productDto, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}
