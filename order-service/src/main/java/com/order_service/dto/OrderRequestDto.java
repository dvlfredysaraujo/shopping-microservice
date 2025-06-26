package com.order_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderRequestDto {
    @NotNull(message = "Custormer ID cannot be null")
    private Integer customerId;

    @NotEmpty(message = "An order must have at least one item")
    @Valid
    private List<DetailOrderDto> items;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<DetailOrderDto> getItems() {
        return items;
    }

    public void setItems(List<DetailOrderDto> items) {
        this.items = items;
    }
}
