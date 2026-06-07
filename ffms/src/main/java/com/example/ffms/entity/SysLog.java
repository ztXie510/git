package com.example.ffms.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * System operation log — records user actions for audit trail.
 */
@Getter
@Setter
public class SysLog extends IdEntity {

    private String username;
    /** Description of the operation performed */
    private String operation;
    /** Method signature or endpoint */
    private String method;
    /** Request parameters (JSON or truncated string) */
    private String params;
    private String ip;
    private LocalDateTime createTime;
    /** Execution time in milliseconds */
    private Long duration;
    /** SUCCESS | FAIL */
    private String resultStatus;
}
