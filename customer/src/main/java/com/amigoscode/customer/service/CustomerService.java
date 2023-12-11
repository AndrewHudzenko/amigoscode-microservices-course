package com.amigoscode.customer.service;

import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.fraud.dto.FraudCheckResponseDto;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.dto.NotificationRequestDto;
import com.amigoscode.customer.dto.CustomerRegistrationRequest;
import com.amigoscode.customer.model.Customer;
import com.amigoscode.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
        RestTemplate restTemplate,
        FraudClient fraudClient,
        NotificationClient notificationClient) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check is fraudster
        FraudCheckResponseDto fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification
        notificationClient.sendNotification(
                new NotificationRequestDto(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s,  welcome to Amigoscode...", customer.getFirstName())
                )
        );
    }
}
