package com.payment_gateway.orders.Payment_Gateway_Order_Backend.repository;

import com.payment_gateway.orders.Payment_Gateway_Order_Backend.dao.model.ProductOrderEntity;
import com.payment_gateway.orders.Payment_Gateway_Order_Backend.data.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;

public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Integer> {

    @Query("SELECT o FROM ProductOrderEntity o WHERE o.id = :orderId")
    ProductOrderEntity findProductOrderById(@Param("orderId") UUID orderId);

    @Query("SELECT o FROM ProductOrderEntity o")
    Page<ProductOrderEntity> findAllProducts(Pageable pageable);

    @Query("SELECT o FROM ProductOrderEntity o WHERE (:textSearch IS NULL OR ilike(o.name, CONCAT('%', :textSearch, '%')) = true " +
            "OR ilike(o.label, CONCAT('%', :textSearch, '%')) = true)")
    Page<ProductOrderEntity> findAllProducts(@Param("textSearch") String textSearch,
                                      Pageable pageable);

}
