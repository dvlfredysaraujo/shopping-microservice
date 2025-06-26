package com.order_service.controller;

import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;
import com.order_service.service.OrderService;
import com.order_service.utils.ApiResponse;
import com.order_service.utils.ResponseUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<OrderResponseDto>> createOrder(
            @Valid @RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto orderResponse = orderService.createOrder(orderRequestDto);
        return ResponseUtils.buildSuccessResponse(orderResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<OrderResponseDto>> getOrderById(@PathVariable Integer id) {
        OrderResponseDto orderResponse = orderService.getOrderById(id);
        return ResponseUtils.buildSuccessResponse(orderResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<OrderResponseDto>>> getOrdersByCustomerId(
            @PathVariable("customerId") Integer customerId) {
        List<OrderResponseDto> orderResponse = orderService.getOrdersByCustomerId(customerId);
        return ResponseUtils.buildSuccessResponse(orderResponse, HttpStatus.OK);
    }
}

