package com.amigoscode.notification.service;

import com.amigoscode.clients.notification.dto.NotificationRequestDto;
import com.amigoscode.notification.model.Notification;
import com.amigoscode.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(
        NotificationRepository notificationRepository
) {

    public void send(NotificationRequestDto notificationRequestDto) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequestDto.toCustomerId())
                        .toCustomerEmail(notificationRequestDto.toCustomerEmail())
                        .sender("Amigoscode")
                        .message(notificationRequestDto.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
