package com.amigoscode.notification.controller;

import com.amigoscode.clients.notification.dto.NotificationRequestDto;
import com.amigoscode.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public record NotificationController(
        NotificationService notificationService) {

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequestDto notificationRequestDto) {
        log.info("New notification... {}", notificationRequestDto);
        notificationService.send(notificationRequestDto);
    }
}
