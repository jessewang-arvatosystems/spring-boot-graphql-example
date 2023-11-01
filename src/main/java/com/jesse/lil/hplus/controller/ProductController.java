package com.jesse.lil.hplus.controller;

import com.jesse.lil.hplus.data.Product;
import com.jesse.lil.hplus.data.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryMapping
    public Iterable<Product> products() {
        return this.productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument final Long id) {
        return this.productRepository.findById(id).orElseThrow();
    }
}
