package me.spring.report;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 定时报表任务实体
 */
@Entity
@Table(name = "report_schedule")
@Getter
@Setter
public class ReportSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String reportName;

    @Column(nullable = false, length = 20)
    private String reportType;

    @Column(nullable = false)
    private Integer ledgerId;

    @Column(nullable = false)
    private Integer createdBy;

    @Column(nullable = false)
    private String cronExpression;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(length = 500)
    private String description;

    @Column(length = 100)
    private String recipients;

    @Column
    private LocalDateTime lastExecuted;

    @Column
    private LocalDateTime nextExecution;

    @Column
    private Integer executionCount;

    @Column
    private String status;

    @Column(length = 20)
    private String exportFormat;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (enabled == null) enabled = true;
        if (executionCount == null) executionCount = 0;
        if (status == null) status = "PENDING";
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}