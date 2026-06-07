package com.example.ffms.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Budget — monthly spending limit, tracked per category or globally.
 */
@Getter
@Setter
public class Budget extends IdEntity {

    private Category category;
    private BigDecimal amount;
    private BigDecimal spent = BigDecimal.ZERO;
    /** MONTHLY | YEARLY | CUSTOM */
    private String periodType;
    private LocalDate startDate;
    private LocalDate endDate;
    private FamilyLedger ledger;
    private SysUser createdBy;
    /** Alert threshold as percentage (e.g., 0.80 = 80%) */
    private BigDecimal alertThreshold;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
