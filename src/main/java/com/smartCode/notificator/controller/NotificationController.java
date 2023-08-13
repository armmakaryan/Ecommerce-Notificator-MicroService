package com.smartCode.notificator.controller;


import com.smartCode.notificator.model.dto.notification.NotificationRequestDto;
import com.smartCode.notificator.model.dto.notification.NotificationResponseDto;
import com.smartCode.notificator.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/create")
    public ResponseEntity<NotificationResponseDto> create(@RequestBody NotificationRequestDto notificationRequestDto) {
        NotificationResponseDto notificationResponseDto = notificationService.create(notificationRequestDto);
        return ResponseEntity.ok(notificationResponseDto);
    }

    @PostMapping("/verify")
    public ResponseEntity<NotificationResponseDto> sendVerificationCode(@RequestBody NotificationRequestDto notificationRequestDto) {
        NotificationResponseDto notificationResponseDto = notificationService.createForVerification(notificationRequestDto);
        return ResponseEntity.ok(notificationResponseDto);
    }

    @GetMapping("/ready")
    public ResponseEntity<List<NotificationResponseDto>> getReady(@RequestParam Integer userId) {
        List<NotificationResponseDto> readyNotifications = notificationService.getNotifications(true, userId);
        return ResponseEntity.ok(readyNotifications);
    }

    @GetMapping("/waiting")
    public ResponseEntity<List<NotificationResponseDto>> getWaiting(@RequestParam Integer userId) {
        List<NotificationResponseDto> readyNotifications = notificationService.getNotifications(false, userId);
        return ResponseEntity.ok(readyNotifications);
    }

}