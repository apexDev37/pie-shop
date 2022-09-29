package com.demo.pieshop.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // required custom query methods
    // ...
}
