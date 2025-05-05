package com.payment_gateway.orders.Payment_Gateway_Order_Backend.service;

import com.payment_gateway.orders.Payment_Gateway_Order_Backend.dao.OrderStatus;
import com.payment_gateway.orders.Payment_Gateway_Order_Backend.dao.model.ProductOrderEntity;
import com.payment_gateway.orders.Payment_Gateway_Order_Backend.data.ProductOrder;
import com.payment_gateway.orders.Payment_Gateway_Order_Backend.mapper.ProductOrderMapper;
import com.payment_gateway.orders.Payment_Gateway_Order_Backend.repository.ProductOrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Value("${razorpay.key.id}")
    private String razorPayKey;

    @Value("${razorpay.secret.key}")
    private String razorPaySecret;

    private RazorpayClient razorpayClient;

    public ProductOrder createProductOrder(ProductOrder productOrder) throws Exception {
        JSONObject productOrderData = new JSONObject();
        productOrderData.put("amount", productOrder.getAmount());
        productOrderData.put("currency", "INR");
        productOrderData.put("receipt", productOrder.getProductName());

        this.razorpayClient = new RazorpayClient(razorPayKey, razorPaySecret);

        // create order in razorpay
        Order razorPayOrder = razorpayClient.orders.create(productOrderData);
        if (razorPayOrder.get("status").equals("created"))
            productOrder.setStatus(OrderStatus.PENDING);
        ProductOrderEntity productOrderEntity = ProductOrderMapper.toEntity(productOrder);
        return ProductOrderMapper.toDto(productOrderRepository.save(productOrderEntity));
    }

    public ProductOrder getProductOrderById(UUID orderId) {
        return ProductOrderMapper.toDto(productOrderRepository.findProductOrderById(orderId));
    }
}
