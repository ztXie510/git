package com.example.ffms.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Income or expense transaction record — the core data entity of FFMS.
 */
@Getter
@Setter
public class Transaction extends IdEntity {

    /** INCOME | EXPENSE */
    private String type;
    private BigDecimal amount;
    private Category category;
    private Account account;
    private LocalDateTime transactionDate;
    private String description;
    private SysUser createdBy;
    private FamilyLedger ledger;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
