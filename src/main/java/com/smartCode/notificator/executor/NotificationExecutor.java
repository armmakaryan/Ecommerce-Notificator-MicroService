package com.smartCode.notificator.executor;

import com.smartCode.notificator.model.entity.NotificationEntity;
import com.smartCode.notificator.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationExecutor {

    private final NotificationService notificationService;

    @Scheduled(fixedDelay = 30000)
    public void start() throws InterruptedException {
        List<NotificationEntity> list = notificationService.getReadyNotifications();
        for (NotificationEntity notificationEntity : list) {
            notificationService.sendNotification(notificationEntity);
        }
    }

}
