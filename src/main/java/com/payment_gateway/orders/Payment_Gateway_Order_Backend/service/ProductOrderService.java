package com.payment_gateway.orders.Payment_Gateway_Order_Backend.service;

import com.payment_gateway.orders.Payment_Gateway_Order_Backend.data.ProductOrder;
import com.payment_gateway.orders.Payment_Gateway_Order_Backend.repository.ProductOrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
        productOrder.setStatus(razorPayOrder.get("status"));
        ProductOrder savedProductOrder = productOrderRepository.save(productOrder);
        return productOrder;
    }
}
