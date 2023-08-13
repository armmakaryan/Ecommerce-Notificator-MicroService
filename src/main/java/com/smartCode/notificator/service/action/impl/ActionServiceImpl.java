package com.smartCode.notificator.service.action.impl;

import com.smartCode.notificator.mapper.ActionMapper;
import com.smartCode.notificator.model.dto.action.ActionRequestDto;
import com.smartCode.notificator.model.entity.ActionEntity;
import com.smartCode.notificator.repository.ActionRepository;
import com.smartCode.notificator.service.action.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;
    private final ActionMapper actionMapper;

    @Override
    @Transactional
    public void saveAction(ActionRequestDto actionRequestDto) {
        ActionEntity entity = actionMapper.toEntity(actionRequestDto);
        actionRepository.save(entity);
    }
}