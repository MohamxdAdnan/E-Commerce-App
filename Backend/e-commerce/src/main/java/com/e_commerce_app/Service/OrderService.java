package com.e_commerce_app.Service;

import com.e_commerce_app.Dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder (OrderDto orderDto);
    OrderDto updateOrder (OrderDto orderDto,Long orderId);
    void deleteOrder (Long orderId);
    OrderDto getOrder (Long orderId);
    List<OrderDto> getAllOrders ();
}
