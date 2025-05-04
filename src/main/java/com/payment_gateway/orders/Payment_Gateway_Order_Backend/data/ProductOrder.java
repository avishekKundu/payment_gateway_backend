package com.payment_gateway.orders.Payment_Gateway_Order_Backend.data;

import com.payment_gateway.orders.Payment_Gateway_Order_Backend.dao.OrderStatus;
import java.math.BigDecimal;
import java.net.URL;
import java.util.UUID;

public class ProductOrder {

    private UUID id;

    private String productName;

    private BigDecimal amount;

    private OrderStatus status;

    private URL paymentLink;

    public ProductOrder() {
        super();
    }

    public ProductOrder(ProductOrder productOrder) {
        this.id = productOrder.getId();
        this.productName = productOrder.getProductName();
        this.amount = productOrder.getAmount();
        this.status = productOrder.getStatus();
        this.paymentLink = productOrder.getPaymentLink();
    }

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

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", paymentLink=" + paymentLink +
                '}';
    }
}
