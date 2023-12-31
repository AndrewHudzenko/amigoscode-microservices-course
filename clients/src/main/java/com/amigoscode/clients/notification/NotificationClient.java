package com.amigoscode.clients.notification;

import com.amigoscode.clients.notification.dto.NotificationRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "notification",
        url = "${clients.notification.url}"
)
public interface NotificationClient {

    @PostMapping("api/v1/notification")
    void sendNotification(NotificationRequestDto notificationRequestDto);
}
