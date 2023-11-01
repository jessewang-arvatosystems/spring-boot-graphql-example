package com.jesse.lil.hplus.controller;

import com.jesse.lil.hplus.data.Customer;
import com.jesse.lil.hplus.data.CustomerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public Iterable<Customer> customers() {
        return this.customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument final Long id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Customer customerByEmail(@Argument final String email) {
        return this.customerRepository.findCustomerByEmail(email);
    }

    @MutationMapping
    public Customer addCustomer(@Argument(name="input") final CustomerInput customerInput) {
        return this.customerRepository.save(customerInput.getCustomerEntity());
    }

    @MutationMapping
    public Customer updateCustomerById(@Argument final Long id, @Argument(name="input") final CustomerInput customerInput) {
        final Customer customer = customerInput.getCustomerEntity();
        customer.setId(id);
        return this.customerRepository.save(customer);
    }

    @MutationMapping
    public Long removeCustomerById(@Argument final Long id) {
        final boolean exists = this.customerRepository.existsById(id);
        if (!exists) {
            throw new DataIntegrityViolationException("Customer with id " + id + " does not exist");
        }
        this.customerRepository.deleteById(id);
        return id;
    }
}
