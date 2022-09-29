package com.demo.pieshop.Customer;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {

    // members

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(
            name = "customer_id",
            updatable = false
    )
    private Long customerId;

    @Column(
            name = "customer_first_name",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String firstName;

    @Column(
            name = "customer_last_name",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String lastName;

    @Column(
            name = "customer_address",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String address;

    @Column(
            name = "customer_state",
            nullable = false,
            columnDefinition = "VARCHAR(20)"
    )
    private String state;

    @Column(
            name = "customer_postal_code",
            nullable = false,
            columnDefinition = "SMALLINT"
    )
    private Integer postalCode;

    @Column(
            name = "customer_comments",
            columnDefinition = "TEXT"
    )
    private String comments;

    // constructors

    public Customer(
            String firstName,
            String lastName,
            String address,
            String state,
            Integer postalCode,
            String comments) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.postalCode = postalCode;
        this.comments = comments;
    }

    public Customer() {}

    // getters

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getComments() {
        return comments;
    }

    // setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", comments='" + comments + '\'' +
                '}';
    }
}
