package com.jesse.lil.hplus.controller;

import com.jesse.lil.hplus.data.Salesperson;
import com.jesse.lil.hplus.data.SalespersonRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SalespersonController {
    private final SalespersonRepository salespersonRepository;

    public SalespersonController(final SalespersonRepository salespersonRepository) {
        this.salespersonRepository = salespersonRepository;
    }

    @QueryMapping
    public Iterable<Salesperson> salespeople() {
        return this.salespersonRepository.findAll();
    }

    @QueryMapping
    public Salesperson salespersonById(@Argument final Long id) {
        return this.salespersonRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Salesperson salespersonByEmail(@Argument final String email) {
        return this.salespersonRepository.findSalespersonByEmail(email);
    }
}
