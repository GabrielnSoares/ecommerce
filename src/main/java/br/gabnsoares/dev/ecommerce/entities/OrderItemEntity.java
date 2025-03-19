package br.gabnsoares.dev.ecommerce.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemId id;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderItemEntity() {
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId id) {
        this.id = id;
    }
}
