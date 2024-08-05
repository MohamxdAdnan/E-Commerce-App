package com.e_commerce_app.Service;


import com.e_commerce_app.Dto.CartDto;

import java.util.List;

public interface CartService {
    CartDto createCart (CartDto cartDto);
    CartDto updateCart (CartDto cartDto,Long cartId);
    void deleteCart (Long cartId);
    CartDto getCart (Long cartId);
    List<CartDto> getAllCarts ();
}
