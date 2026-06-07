package me.spring.config;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 动态配置实体
 */
@Entity
@Table(name = "dynamic_config")
@Getter
@Setter
public class DynamicConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String configKey;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String configValue;

    @Column(nullable = false, length = 50)
    private String configType; // STRING, INTEGER, BOOLEAN, JSON

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false)
    private Integer createdBy;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(nullable = false)
    private Boolean sensitive;

    @Column
    private LocalDateTime lastModified;

    @Column(length = 50)
    private String modifiedBy;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (enabled == null) enabled = true;
        if (sensitive == null) sensitive = false;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
        lastModified = LocalDateTime.now();
    }
}