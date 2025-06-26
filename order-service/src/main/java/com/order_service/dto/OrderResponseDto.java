package com.order_service.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Integer orderId;
    private Integer customerId;
    private String status;
    private LocalDateTime createdAt;
    private Float totalAmount;
    private List<DetailOrderDto> items;

    public OrderResponseDto() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<DetailOrderDto> getItems() {
        return items;
    }

    public void setItems(List<DetailOrderDto> items) {
        this.items = items;
    }
}
