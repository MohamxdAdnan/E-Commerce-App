package com.e_commerce_app.Controller;

import com.e_commerce_app.Dto.CartDto;
import com.e_commerce_app.Dto.ProductDto;
import com.e_commerce_app.Repository.CartRepository;
import com.e_commerce_app.Service.CartService;
import com.e_commerce_app.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/Cart")
public class CartController {
    private CartService cartService;
    @GetMapping("{id}")
    public ResponseEntity<CartDto> getCart(@PathVariable Long id) {
        CartDto cartDto = cartService.getCart(id);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>("Cart deleted", HttpStatus.NO_CONTENT);
    }
    @PutMapping("{id}")
    public ResponseEntity<CartDto> updateCart(@RequestBody CartDto cartDto, @PathVariable Long id) {
        CartDto updatedCart = cartService.updateCart(cartDto, id);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }
}
