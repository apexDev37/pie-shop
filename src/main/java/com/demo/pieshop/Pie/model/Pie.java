package com.demo.pieshop.Pie.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Pie")
@Table(
        name = "pie",
        uniqueConstraints = {
                @UniqueConstraint(name = "pie_title_unique", columnNames = "pie_title")
        }
)
public class Pie {

    // members

    @Id
    @SequenceGenerator(
            name = "pie_sequence",
            sequenceName = "pie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "pie_sequence"
    )
    @Column(
            name = "pie_id",
            updatable = false
    )
    private Long pieId;

    @Column(
            name = "pie_title",
            nullable = false,
            columnDefinition = "VARCHAR(20)"
    )
    private String pieTitle;

    @Column(
            name = "pie_price",
            nullable = false,
            columnDefinition = "NUMERIC(4, 2)"
    )
    private double piePrice;

    @Column(
            name = "pie_description",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String pieDescription;

    @Column(
            name = "pie_has_image",
            nullable = false,
            columnDefinition = "BOOLEAN"
    )
    private Boolean pieHasImage;

    // constructor

    public Pie(
            String pieTitle,
            double piePrice,
            String pieDescription,
            Boolean pieHasImage) {

        this.pieTitle = pieTitle;
        this.piePrice = piePrice;
        this.pieDescription = pieDescription;
        this.pieHasImage = pieHasImage;
    }

    public Pie() {}

    // getters

    public Long getPieId() {
        return pieId;
    }

    public String getPieTitle() {
        return pieTitle;
    }

    public double getPiePrice() {
        return piePrice;
    }

    public String getPieDescription() {
        return pieDescription;
    }

    public Boolean getPieHasImage() {
        return pieHasImage;
    }

    // setters

    public void setPieId(Long pieId) {
        this.pieId = pieId;
    }

    public void setPieTitle(String pieTitle) {
        this.pieTitle = pieTitle;
    }

    public void setPiePrice(double piePrice) {
        this.piePrice = piePrice;
    }

    public void setPieDescription(String pieDescription) {
        this.pieDescription = pieDescription;
    }

    public void setPieHasImage(Boolean pieHasImage) {
        this.pieHasImage = pieHasImage;
    }

    @Override
    public String toString() {
        return "Pie{" +
                "pieId=" + pieId +
                ", pieTitle='" + pieTitle + '\'' +
                ", piePrice=" + piePrice +
                ", pieDescription='" + pieDescription + '\'' +
                ", pieHasImage=" + pieHasImage +
                '}';
    }
}
