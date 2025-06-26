package com.order_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detail_orders")
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Product ID cannot be null")
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Min(value = 1, message = "Quantity must be at least 1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Min(value = 0, message = "Unit price must be non-negative")
    @Column(name = "unit_price", nullable = false)
    private Float unitPrice;

    @Min(value = 0, message = "Subtotal must be non-negative")
    @Column(name = "sub_total", nullable = false)
    private Float subTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public DetailOrder() {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
