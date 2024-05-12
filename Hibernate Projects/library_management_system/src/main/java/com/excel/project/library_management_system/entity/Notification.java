package com.excel.project.library_management_system.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "notification_type")
    private String notificationType;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sent_datetime")
    private Date sentDatetime;

    @Column(name = "is_read")
    private Boolean read;
}
