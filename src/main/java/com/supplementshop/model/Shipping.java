package com.supplementshop.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "shipping_country")
    private String shippingCountry;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "shipping_price")
    private BigDecimal shippingPrice;

    @Column(name = "tracking_number")
    private String trackingNumber;
}