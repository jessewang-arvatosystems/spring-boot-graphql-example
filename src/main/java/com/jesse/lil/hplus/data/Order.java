package com.jesse.lil.hplus.data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "SALESPERSON_ID", nullable = false, updatable = false)
    private Salesperson salesperson;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(final Salesperson salesperson) {
        this.salesperson = salesperson;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(final List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
