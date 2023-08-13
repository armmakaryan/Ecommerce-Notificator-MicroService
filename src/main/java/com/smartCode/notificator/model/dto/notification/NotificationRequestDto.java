package com.smartCode.notificator.model.dto.notification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationRequestDto {

    private Integer userId;

    private String title;

    private String content;

    private String description;

    private Long notificationDate;

    private Long createDate;

    private Boolean sent;

    private String email;

}