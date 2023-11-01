package com.jesse.lil.hplus.controller;

import com.jesse.lil.hplus.data.OrderLine;
import com.jesse.lil.hplus.data.OrderLineRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderLineController {
    private final OrderLineRepository orderLineRepository;

    public OrderLineController(final OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @QueryMapping
    public Iterable<OrderLine> orderLines() {
        return this.orderLineRepository.findAll();
    }

    @QueryMapping
    public OrderLine orderLineById(@Argument final Long id) {
        return this.orderLineRepository.findById(id).orElseThrow();
    }
}
