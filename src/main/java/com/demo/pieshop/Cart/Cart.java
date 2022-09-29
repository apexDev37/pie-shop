package com.demo.pieshop.Cart;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "Cart")
@Table(
        name = "customer_cart",
        uniqueConstraints = {
            @UniqueConstraint(name = "cart_customer_id_unique", columnNames = "cart_customer_id")
        }
)
public class Cart {

    // members

    @Id
    @GeneratedValue
    @Column(
            name = "cart_id",
            updatable = false,
            columnDefinition = "UUID"
    )
    private UUID cartId;

    @Column(
            name = "cart_customer_id",
            nullable = false,
            columnDefinition = "SMALLINT"
    )
    private Long customerId;

    @Column(
            name = "cart_total_price",
            nullable = false,
            columnDefinition = "NUMERIC(5, 2)"
    )
    private Double totalPrice;

    @Column(
            name = "cart_subtotal_price",
            nullable = false,
            columnDefinition = "NUMERIC(5, 2)"
    )
    private Double subtotalPrice;

    @Column(
            name = "cart_total_items",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private Integer totalItems;

    @Column(
            name = "cart_generated_at",
            insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAndTimeGenerated;


    // constructors

    public Cart(
            Long customerId,
            Double totalPrice,
            Double subtotalPrice,
            Integer totalItems) {

        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.subtotalPrice = subtotalPrice;
        this.totalItems = totalItems;
    }

    public Cart() {

    }

    // getters

    public UUID getCartId() {
        return cartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double getSubtotalPrice() {
        return subtotalPrice;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public Date getDateAndTimeGenerated() {
        return dateAndTimeGenerated;
    }

    // setters

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setSubtotalPrice(Double subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

}
