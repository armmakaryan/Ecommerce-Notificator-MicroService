package com.smartCode.notificator.service.notification.impl;

import com.smartCode.notificator.mapper.NotificationMapper;
import com.smartCode.notificator.model.dto.notification.NotificationRequestDto;
import com.smartCode.notificator.model.dto.notification.NotificationResponseDto;
import com.smartCode.notificator.model.entity.NotificationEntity;
import com.smartCode.notificator.repository.NotificationRepository;
import com.smartCode.notificator.service.email.EmailService;
import com.smartCode.notificator.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationMapper notificationMapper;
    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @Override
    @Transactional(readOnly = true)
    public List<NotificationResponseDto> getNotifications(Boolean sent, Integer userId) {
        List<NotificationEntity> allBySentAndUserId = notificationRepository.findAllBySentAndUserId(sent, userId);
        return notificationMapper.toDtoList(allBySentAndUserId);
    }

    @Override
    @Transactional
    public NotificationResponseDto create(NotificationRequestDto notificationRequestDto) {
        NotificationEntity entity = notificationMapper.toEntity(notificationRequestDto);
        return notificationMapper.toDto(notificationRepository.save(entity));
    }

    @Override
    @Transactional
    public NotificationResponseDto createForVerification(NotificationRequestDto notificationRequestDto) {
        NotificationEntity entity = notificationMapper.toEntity(notificationRequestDto);
        entity.setNotificationDate(System.currentTimeMillis());
        entity.setCreateDate(System.currentTimeMillis());
        emailService.sendSimpleMessage(entity.getEmail(), entity.getTitle(), entity.getContent());
        entity.setSent(true);
        notificationRepository.save(entity);
        return notificationMapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationEntity> getReadyNotifications() {
        return notificationRepository.getReadyNotifications(System.currentTimeMillis());
    }

    @Override
    @Transactional
    @Async("notificationSenderExecutors")
    public void sendNotification(NotificationEntity notificationEntity) {
        long waitTime = notificationEntity.getNotificationDate() - System.currentTimeMillis();
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        emailService.sendSimpleMessage(notificationEntity.getEmail(),
                notificationEntity.getTitle(),
                notificationEntity.getContent());
        notificationEntity.setSent(true);
        notificationRepository.save(notificationEntity);
    }
}