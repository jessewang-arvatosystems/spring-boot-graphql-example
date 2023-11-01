package com.jesse.lil.hplus.data;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDER_LINES")
public class OrderLine {
    @Id
    @Column(name = "ORDER_LINE_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", nullable = false, updatable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false)
    private Product product;

    @Column(name = "QUANTITY")
    private int quantity;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(final Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
