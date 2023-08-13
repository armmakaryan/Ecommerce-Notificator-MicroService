package com.smartCode.notificator.service.notification;

import com.smartCode.notificator.model.dto.action.ActionRequestDto;
import com.smartCode.notificator.model.dto.notification.NotificationRequestDto;
import com.smartCode.notificator.model.dto.notification.NotificationResponseDto;
import com.smartCode.notificator.model.entity.NotificationEntity;

import java.util.List;


public interface NotificationService {
    NotificationResponseDto create(NotificationRequestDto notificationRequestDto);

    List<NotificationResponseDto> getNotifications(Boolean sent, Integer userId);

    NotificationResponseDto createForVerification(NotificationRequestDto notificationRequestDto);

    List<NotificationEntity> getReadyNotifications();

    void sendNotification(NotificationEntity notificationEntity);

}