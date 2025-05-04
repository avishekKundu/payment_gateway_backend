package com.payment_gateway.orders.Payment_Gateway_Order_Backend.repository;

import com.payment_gateway.orders.Payment_Gateway_Order_Backend.data.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
