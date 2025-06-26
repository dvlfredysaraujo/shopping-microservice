package com.order_service.service;

import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
    OrderResponseDto getOrderById(Integer orderId);
    List<OrderResponseDto> getOrdersByCustomerId(Integer customerId);
}
