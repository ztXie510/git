package me.spring.importexport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;

/**
 * 数据导入任务实体
 */
@Entity
@Table(name = "import_job")
@Getter
@Setter
public class ImportJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String taskId;

    @Column(nullable = false)
    private Integer ledgerId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false, length = 50)
    private String dataType; // TRANSACTION, BUDGET, ACCOUNT, CATEGORY

    @Column(nullable = false)
    private Integer fileSize;

    @Column(nullable = false, length = 100)
    private String fileName;

    @Column(nullable = false, length = 20)
    private String status; // PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED

    @Column(nullable = false)
    private Integer totalRecords;

    @Column
    private Integer processedRecords;

    @Column
    private Integer successRecords;

    @Column
    private Integer failedRecords;

    @Column(columnDefinition = "TEXT")
    private String errorDetails;

    @Column(length = 20)
    private String exportFormat; // CSV, Excel

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private BigDecimal processingTime; // 处理时间（秒）

    @Column
    private Integer retryCount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) status = "PENDING";
        if (totalRecords == null) totalRecords = 0;
        if (processedRecords == null) processedRecords = 0;
        if (successRecords == null) successRecords = 0;
        if (failedRecords == null) failedRecords = 0;
        if (retryCount == null) retryCount = 0;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}