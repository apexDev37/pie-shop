package com.demo.pieshop.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/cart")
public class CartResource {

    // cart repository

    private final CartRepository cartRepository;

    @Autowired
    public CartResource(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // order API services

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart requestCart) {
        try {
            Cart newlyAddedCart = cartRepository.save(
                    new Cart(
                        requestCart.getCustomerId(),
                        requestCart.getTotalPrice(),
                        requestCart.getSubtotalPrice(),
                        requestCart.getTotalItems()
            ));
            return new ResponseEntity<>(newlyAddedCart, HttpStatus.CREATED);
        } catch (Exception errors) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
