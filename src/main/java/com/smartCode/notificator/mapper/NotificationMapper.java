package com.smartCode.notificator.mapper;

import com.smartCode.notificator.model.dto.notification.NotificationRequestDto;
import com.smartCode.notificator.model.dto.notification.NotificationResponseDto;
import com.smartCode.notificator.model.entity.NotificationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationEntity toEntity(NotificationRequestDto notificationRequestDto);
    NotificationResponseDto toDto(NotificationEntity notificationEntity);
    List<NotificationResponseDto> toDtoList (List<NotificationEntity> notificationEntities);
}