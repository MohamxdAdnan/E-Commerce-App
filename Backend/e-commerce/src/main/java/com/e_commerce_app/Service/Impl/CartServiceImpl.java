package com.e_commerce_app.Service.Impl;

import com.e_commerce_app.Dto.CartDto;
import com.e_commerce_app.Entity.Cart;
import com.e_commerce_app.Exception.ResourceNotFoundException;
import com.e_commerce_app.Repository.CartRepository;

import com.e_commerce_app.Service.CartService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private ModelMapper modelMapper;
    @Override
    public CartDto createCart(CartDto cartDto) {
        Cart cart=modelMapper.map(cartDto,Cart.class);
        Cart newCart = cartRepository.save(cart);
        return modelMapper.map(newCart, CartDto.class);
    }

    @Override
    public CartDto updateCart(CartDto cartDto, Long cartId) {
        Cart cart=cartRepository.findById(cartId)
                .orElseThrow(()-> new ResourceNotFoundException("Cart Not Found with ID : " + cartId));
        cart.setQuantity(cartDto.getQuantity());

        Cart savedCart = cartRepository.save(cart);
        return modelMapper.map(savedCart, CartDto.class);
    }

    @Override
    public void deleteCart(Long cartId) {
        Cart cart=cartRepository.findById(cartId)
                .orElseThrow(()-> new ResourceNotFoundException("Cart Not Found with ID : " + cartId));
        cartRepository.delete(cart);
    }

    @Override
    public CartDto getCart(Long cartId) {
        Cart cart=cartRepository.findById(cartId)
                .orElseThrow(()-> new ResourceNotFoundException("Cart Not Found with ID : " + cartId));
        return modelMapper.map(cart,CartDto.class);
    }

    @Override
    public List<CartDto> getAllCarts() {
        List<Cart> allCarts = cartRepository.findAll();
        List<CartDto> allCartDtos = allCarts.stream()
                .map((cart)-> modelMapper.map(cart,CartDto.class))
                .collect(Collectors.toList());
        return allCartDtos;
    }
}
