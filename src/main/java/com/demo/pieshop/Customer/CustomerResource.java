package com.demo.pieshop.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/customer")

public class CustomerResource {

    // customer repository
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerResource(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // customer API services

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@Valid @NotNull @RequestBody Customer customer) {
        try {
            Customer addedCustomer = customerRepository.save(
                    new Customer(
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getAddress(),
                            customer.getState(),
                            customer.getPostalCode(),
                            customer.getComments()
                    ));
            return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
        } catch (Exception errors) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
