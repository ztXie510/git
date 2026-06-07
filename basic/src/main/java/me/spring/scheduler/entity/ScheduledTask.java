package me.spring.scheduler;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;

/**
 * 定时任务实体
 */
@Entity
@Table(name = "scheduled_task")
@Getter
@Setter
public class ScheduledTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String taskId;

    @Column(nullable = false, length = 100)
    private String taskName;

    @Column(nullable = false, length = 20)
    private String taskType; // JOB, SCRIPT, API

    @Column(nullable = false, length = 200)
    private String taskGroup;

    @Column(nullable = false, columnDefinition = "TEXT")
    private taskDefinition;

    @Column(nullable = false, length = 100)
    private String cronExpression;

    @Column(nullable = false)
    private Integer ledgerId;

    @Column(nullable = false)
    private Integer createdBy;

    @Column(nullable = false, length = 20)
    private String status; // ENABLED, DISABLED, RUNNING, FAILED

    @Column(nullable = false)
    private Boolean enabled;

    @Column(nullable = false)
    private Boolean concurrent;

    @Column(nullable = false)
    private Integer retryCount;

    @Column(nullable = false)
    private Integer maxRetries;

    @Column(nullable = false)
    private BigDecimal timeout; // 超时时间（秒）

    @Column(length = 500)
    private String description;

    @Column(length = 500)
    private String params;

    @Column(length = 100)
    private String errorHandler;

    @Column(length = 100)
    private String successHandler;

    @Column
    private LocalDateTime lastExecutionTime;

    @Column
    private LocalDateTime nextExecutionTime;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private Integer executionCount;

    @Column
    private Integer successCount;

    @Column
    private Integer failureCount;

    @Column(length = 20)
    private String priority; // HIGH, MEDIUM, LOW

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (enabled == null) enabled = true;
        if (concurrent == null) concurrent = false;
        if (retryCount == null) retryCount = 0;
        if (maxRetries == null) maxRetries = 3;
        if (timeout == null) timeout = new BigDecimal("300");
        if (executionCount == null) executionCount = 0;
        if (successCount == null) successCount = 0;
        if (failureCount == null) failureCount = 0;
        if (priority == null) priority = "MEDIUM";
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}