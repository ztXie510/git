package com.example.ffms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * System operation log — records user actions for audit trail.
 */
@Entity
@Table(name = "sys_log")
@Getter
@Setter
public class SysLog extends IdEntity {

    @Column(length = 50)
    private String username;

    /** Description of the operation performed */
    @Column(nullable = false, length = 200)
    private String operation;

    /** Method signature or endpoint */
    @Column(length = 300)
    private String method;

    /** Request parameters (JSON or truncated string) */
    @Column(columnDefinition = "TEXT")
    private String params;

    @Column(length = 50)
    private String ip;

    private LocalDateTime createTime;

    /** Execution time in milliseconds */
    private Long duration;

    /** SUCCESS | FAIL */
    @Column(length = 10)
    private String resultStatus;

    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
    }
}
