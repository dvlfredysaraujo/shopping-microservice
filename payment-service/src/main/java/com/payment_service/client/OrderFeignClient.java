package com.payment_service.client;

import com.payment_service.client.dto.OrderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "${order.service.url}")
public interface OrderFeignClient {

    @GetMapping(value = "/api/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderResponseDto getOrderById(@PathVariable Integer id);
}
