package com.order_service.service.impl;

import com.order_service.client.ProductFeignClient;
import com.order_service.client.dto.ProductResponse;
import com.order_service.client.dto.ProductSpecifications;
import com.order_service.dto.DetailOrderDto;
import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;
import com.order_service.exception.BadRequestException;
import com.order_service.exception.OrderValidationException;
import com.order_service.exception.ResourceNotFoundException;
import com.order_service.model.DetailOrder;
import com.order_service.model.Order;
import com.order_service.repository.DetailOrderRepository;
import com.order_service.repository.OrderRepository;
import com.order_service.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DetailOrderRepository detailOrderRepository;
    private final ProductFeignClient productFeignClient;

    public OrderServiceImpl(OrderRepository orderRepository, ProductFeignClient productFeignClient,
                            DetailOrderRepository detailOrderRepository) {
        this.orderRepository = orderRepository;
        this.detailOrderRepository = detailOrderRepository;
        this.productFeignClient = productFeignClient;
    }

    @Override
    public OrderResponseDto createOrder(@Valid OrderRequestDto orderRequest) {

        if(orderRequest.getCustomerId() == null) {
            throw new BadRequestException("Customer ID cannot be null");
        }

        if(orderRequest.getItems() == null || orderRequest.getItems().isEmpty()) {
            throw new OrderValidationException("An order must have at least one item");
        }

        Order order = new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDateTime.now());
        order.setTotalAmount(0f); // Initialize total amount

        float total = 0f;
        for (DetailOrderDto itemDto : orderRequest.getItems()){
            ProductResponse product = productFeignClient.getProductById(itemDto.getProductId());

            if (product == null) {
                throw new OrderValidationException("Product with ID " + itemDto.getProductId() + " does not exist");
            }

            float unitPrice = product.getData().getPrice();
            int quantity = itemDto.getQuantity();
            float subTotal = unitPrice * quantity;
            total += subTotal;

            DetailOrder detail = new DetailOrder();
            detail.setProductId(itemDto.getProductId());
            detail.setUnitPrice(unitPrice);
            detail.setQuantity(quantity);
            detail.setSubTotal(subTotal);

            order.addDetail(detail);

        }
        order.setTotalAmount(total);
        Order savedOrder = orderRepository.save(order);
        OrderResponseDto responseDto = mapToOrderResponse(savedOrder);
        return responseDto;

    }

    @Override
    public OrderResponseDto getOrderById(Integer orderId) {
    Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order with ID " + orderId + " does not exist"));
        return mapToOrderResponse(order);
    }

    @Override
    public List<OrderResponseDto> getOrdersByCustomerId(Integer customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream()
                .map(this::mapToOrderResponse)
                .toList();

    }

    private OrderResponseDto mapToOrderResponse(Order order) {
        OrderResponseDto response = new OrderResponseDto();
        response.setOrderId(order.getId());
        response.setCustomerId(order.getCustomerId());
        response.setStatus(order.getStatus());
        response.setCreatedAt(order.getCreatedAt());
        response.setTotalAmount(order.getTotalAmount());
        List<DetailOrderDto> items = order.getDetails().stream()
                .map(detail -> {
                    DetailOrderDto dto = new DetailOrderDto();
                    dto.setId(detail.getId());
                    dto.setProductId(detail.getProductId());
                    dto.setQuantity(detail.getQuantity());
                    dto.setUnitPrice(detail.getUnitPrice());
                    dto.setSubTotal(detail.getSubTotal());
                    return dto;
                }).toList();
        response.setItems(items);
        return response;
    }
}
