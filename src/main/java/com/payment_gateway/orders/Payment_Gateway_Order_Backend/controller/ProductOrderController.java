package com.payment_gateway.orders.Payment_Gateway_Order_Backend.controller;

import com.payment_gateway.orders.Payment_Gateway_Order_Backend.data.ProductOrder;
import com.payment_gateway.orders.Payment_Gateway_Order_Backend.service.ProductOrderService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    @ResponseBody
    public ProductOrder createProductOrder(
            @RequestBody ProductOrder productOrder) throws Exception {
        return productOrderService.createProductOrder(productOrder);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProductOrder getProductOrder(
            @PathVariable("id") String orderId) throws Exception {
        return productOrderService.getProductOrderById(UUID.fromString(orderId));
    }

}
