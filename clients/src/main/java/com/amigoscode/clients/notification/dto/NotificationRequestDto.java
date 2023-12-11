package com.amigoscode.clients.notification.dto;

import java.time.LocalDateTime;

public record NotificationRequestDto(
        Long toCustomerId,
        String toCustomerEmail,
        String message

) {
}
