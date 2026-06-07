package me.spring.notification;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 通知模板实体
 */
@Entity
@Table(name = "notification_template")
@Getter
@Setter
public class NotificationTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String templateCode;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String templateContent;

    @Column(nullable = false, length = 100)
    private String templateName;

    @Column(length = 200)
    private String description;

    @Column(length = 20)
    private String notificationType; // EMAIL, SMS, PUSH, INTERNAL

    @Column(length = 20)
    private String category; // BILL, BUDGET, REPORT, SYSTEM

    @Column
    private Boolean enabled;

    @Column(length = 50)
    private String author;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (enabled == null) enabled = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}