package com.payment_gateway.orders.Payment_Gateway_Order_Backend.mapper;

import com.payment_gateway.orders.Payment_Gateway_Order_Backend.dao.model.ProductOrderEntity;
import com.payment_gateway.orders.Payment_Gateway_Order_Backend.data.ProductOrder;

public class ProductOrderMapper {

    public static ProductOrderEntity toEntity(ProductOrder dto) {
        ProductOrderEntity entity = new ProductOrderEntity();
        entity.setId(dto.getId());
        entity.setProductName(dto.getProductName());
        entity.setAmount(dto.getAmount());
        entity.setStatus(dto.getStatus());
        entity.setPaymentLink(dto.getPaymentLink());
        return entity;
    }

    public static ProductOrder toDto(ProductOrderEntity entity) {
        ProductOrder dto = new ProductOrder();
        dto.setId(entity.getId());
        dto.setProductName(entity.getProductName());
        dto.setAmount(entity.getAmount());
        dto.setStatus(entity.getStatus());
        dto.setPaymentLink(entity.getPaymentLink());
        return dto;
    }

}
