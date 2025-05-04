package com.payment_gateway.orders.Payment_Gateway_Order_Backend.dao.model;

import com.payment_gateway.orders.Payment_Gateway_Order_Backend.dao.OrderStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.net.URL;
import java.util.UUID;

@Entity
@Table(name = "product_order")
public class ProductOrderEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "payment_link")
    private URL paymentLink;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public URL getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(URL paymentLink) {
        this.paymentLink = paymentLink;
    }

}
