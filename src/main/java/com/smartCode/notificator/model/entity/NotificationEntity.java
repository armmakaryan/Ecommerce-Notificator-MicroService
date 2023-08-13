package com.smartCode.notificator.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "notifications")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String description;

    @Column(nullable = false)
    private Long notificationDate;

    @Column(nullable = false)
    private Long createDate;

    @Column(nullable = false)
    private Boolean sent;

    @Column(nullable = false)
    private String email;

}