package me.spring.report;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 报表模板实体
 */
@Entity
@Table(name = "report_template")
@Getter
@Setter
public class ReportTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String templateName;

    @Column(nullable = false)
    private Integer ledgerId;

    @Column(nullable = false, length = 50)
    private String reportType;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String templateContent;

    @Column(length = 500)
    private String description;

    @Column(length = 20)
    private String author;

    @Column
    private Boolean isDefault;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (isDefault == null) isDefault = false;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}