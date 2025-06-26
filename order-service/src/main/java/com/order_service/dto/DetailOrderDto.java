package com.order_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DetailOrderDto {

    private Integer id;

    @NotNull(message = "Product ID cannot be null")
    private Integer productId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @Min(value = 0, message = "Unit price must be non-negative")
    private Float unitPrice;

    @Min(value = 0, message = "Subtotal must be non-negative")
    private Float subTotal;

    public DetailOrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }
}
