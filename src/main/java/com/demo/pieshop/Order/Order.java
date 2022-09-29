package com.demo.pieshop.Order;

import javax.persistence.*;

import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "PieOrder")
@Table(name = "pie_order")
public class Order {

    // members

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_sequence"
    )
    @Column(
            name = "order_id",
            updatable = false
    )
    private Long orderId;

    @Column(
            name = "order_cart_id",
            nullable = false,
            updatable = false,
            columnDefinition = "UUID"
    )
    private UUID cartId;

    @Column(
            name = "order_pie_id",
            nullable = false,
            updatable = false,
            columnDefinition = "BIGINT"
    )
    private Long pieId;

    @Column(
            name = "order_quantity",
            nullable = false,
            updatable = false,
            columnDefinition = "BIGINT"
    )
    private Long orderQuantity;

    // constructors

    public Order(
            UUID cartId,
            Long pieId,
            Long orderQuantity) {

        this.cartId = cartId;
        this.pieId = pieId;
        this.orderQuantity = orderQuantity;
    }

    public Order() {}

    // getters

    public Long getOrderId() {
        return orderId;
    }

    public UUID getCartId() {
        return cartId;
    }

    public Long getPieId() {
        return pieId;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }


    // setters

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public void setPieId(Long pieId) {
        this.pieId = pieId;
    }

    public void setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
