package com.smartCode.notificator.mapper;

import com.smartCode.notificator.model.dto.action.ActionRequestDto;
import com.smartCode.notificator.model.entity.ActionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActionMapper {

    ActionEntity toEntity(ActionRequestDto actionRequestDto);
}