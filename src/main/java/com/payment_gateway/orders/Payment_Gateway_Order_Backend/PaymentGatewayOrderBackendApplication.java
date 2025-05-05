package com.payment_gateway.orders.Payment_Gateway_Order_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAsync
@ComponentScan("com.payment_gateway.orders.Payment_Gateway_Order_Backend")
public class PaymentGatewayOrderBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewayOrderBackendApplication.class, args);
	}

}
