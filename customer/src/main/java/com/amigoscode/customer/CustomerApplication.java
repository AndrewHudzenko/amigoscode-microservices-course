package com.amigoscode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.amigoscode.clients")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.amigoscode.customer",
        "com.amigoscode.amqp"
})
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
