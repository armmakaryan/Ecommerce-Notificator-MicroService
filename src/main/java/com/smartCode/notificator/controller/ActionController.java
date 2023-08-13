package com.smartCode.notificator.controller;

import com.smartCode.notificator.model.dto.action.ActionRequestDto;
import com.smartCode.notificator.service.action.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/action")
public class ActionController {

    private final ActionService actionService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveAction(@RequestBody ActionRequestDto actionRequestDto) {
        actionService.saveAction(actionRequestDto);
        return ResponseEntity.ok().build();
    }

}