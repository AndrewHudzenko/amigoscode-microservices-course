package com.amigoscode.clients.notification.dto;

public record NotificationRequestDto(
        Long toCustomerId,
        String toCustomerEmail,
        String message

) {
}
