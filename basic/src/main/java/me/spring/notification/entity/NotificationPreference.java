package me.spring.notification;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 用户通知偏好设置实体
 */
@Entity
@Table(name = "notification_preference")
@Getter
@Setter
public class NotificationPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer userId;

    @Column(nullable = false, length = 50)
    private String ledgerId;

    @Column(nullable = false)
    private Boolean emailEnabled;

    @Column(nullable = false)
    private Boolean smsEnabled;

    @Column(nullable = false)
    private Boolean pushEnabled;

    @Column(nullable = false)
    private Boolean internalEnabled;

    @Column
    private Boolean billReminderEnabled;

    @Column
    private Boolean budgetWarningEnabled;

    @Column
    private Boolean reportNotificationEnabled;

    @Column
    private Boolean systemNotificationEnabled;

    @Column
    private Integer reminderDaysBefore; // 账单提醒提前天数

    @Column
    private BigDecimal budgetWarningThreshold; // 预算预警阈值

    @Column
    private String emailAddresses;

    @Column
    private String phoneNumbers;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        // 默认启用所有通知
        if (emailEnabled == null) emailEnabled = true;
        if (smsEnabled == null) smsEnabled = false;
        if (pushEnabled == null) pushEnabled = true;
        if (internalEnabled == null) internalEnabled = true;
        if (billReminderEnabled == null) billReminderEnabled = true;
        if (budgetWarningEnabled == null) budgetWarningEnabled = true;
        if (reportNotificationEnabled == null) reportNotificationEnabled = true;
        if (systemNotificationEnabled == null) systemNotificationEnabled = true;
        if (reminderDaysBefore == null) reminderDaysBefore = 3;
        if (budgetWarningThreshold == null) budgetWarningThreshold = new BigDecimal("0.8");
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}