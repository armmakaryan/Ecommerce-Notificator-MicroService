package com.smartCode.notificator.model.entity;

import javax.persistence.*;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "action")
public class ActionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String actionType;

    private String entityType;

    private LocalDateTime actionDate;

    private Integer userId;
}