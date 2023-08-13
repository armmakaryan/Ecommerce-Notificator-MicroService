package com.smartCode.notificator.model.dto.action;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ActionRequestDto {

    private String actionType;

    private String entityType;

    private LocalDateTime actionDate;

    private Integer userId;

}