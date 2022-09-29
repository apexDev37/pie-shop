package com.demo.pieshop.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/order")
public class OrderResource {

    // order repository
    private final OrderRepository orderRepository;

    @Autowired
    public OrderResource(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // order API services

    @PostMapping
    public ResponseEntity<List<Order>> addOrder(@Valid @NotNull @RequestBody List<Order> orders) {
        try {
            List<Order> customerOrdersInCart = orders
                    .stream()
                    .map(order -> new Order(
                        order.getCartId(),
                        order.getPieId(),
                        order.getOrderQuantity()
            )).collect(Collectors.toList());
            orderRepository.saveAll(customerOrdersInCart);
            return new ResponseEntity<>(customerOrdersInCart, HttpStatus.CREATED);
        } catch (Exception errors) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
