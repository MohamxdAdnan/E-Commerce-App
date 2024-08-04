package com.e_commerce_app.Service.Impl;

import com.e_commerce_app.Dto.OrderDto;
import com.e_commerce_app.Entity.Orders;
import com.e_commerce_app.Exception.ResourceNotFoundException;
import com.e_commerce_app.Repository.OrderRepository;
import com.e_commerce_app.Service.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapper modelMapper;
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Orders orders =modelMapper.map(orderDto, Orders.class);
        Orders newOrders = orderRepository.save(orders);
        return modelMapper.map(newOrders, OrderDto.class);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, Long orderId) {
        Orders orders =orderRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Order Not Found with ID : " + orderId));
        orders.setOrderDate(orderDto.getOrderDate());
        orders.setTotalPrice(orderDto.getTotalPrice());

        Orders newOrders = orderRepository.save(orders);
        return modelMapper.map(newOrders,OrderDto.class);
    }

    @Override
    public void deleteOrder(Long orderId) {
        Orders orders =orderRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Order Not Found with ID : " + orderId));
        orderRepository.delete(orders);
    }

    @Override
    public OrderDto getOrder(Long orderId) {
        Orders orders =orderRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Order Not Found with ID : " + orderId));
        return modelMapper.map(orders, OrderDto.class);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Orders> allOrders = orderRepository.findAll();
        List<OrderDto> allOrderDtos = allOrders.stream()
                .map((orders)-> modelMapper.map(orders,OrderDto.class))
                .collect(Collectors.toList());
        return allOrderDtos;
    }
}
