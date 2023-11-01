package com.jesse.lil.hplus.controller;

import com.jesse.lil.hplus.data.Order;
import com.jesse.lil.hplus.data.OrderRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @QueryMapping
    public Iterable<Order> orders() {
        return this.orderRepository.findAll();
    }

    @QueryMapping
    public Order orderById(@Argument final Long id) {
        return this.orderRepository.findById(id).orElseThrow();
    }
}
