package com.amigoscode.notification.rabbitmq;

import com.amigoscode.clients.notification.dto.NotificationRequestDto;
import com.amigoscode.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequestDto notificationRequestDto) {
         log.info("Consumed {} from queue", notificationRequestDto);
        notificationService.send(notificationRequestDto);
    }
}
