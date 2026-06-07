package com.example.ffms.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Fixed bill — credit card, mortgage, rent, utilities with recurring reminders.
 */
@Getter
@Setter
public class Bill extends IdEntity {

    private String name;
    private BigDecimal amount;
    private LocalDate dueDate;
    /** CREDIT_CARD | MORTGAGE | CAR_LOAN | RENT | UTILITY | OTHER */
    private String billType;
    /** PENDING | PAID | OVERDUE */
    private String status;
    private Account account;
    private FamilyLedger ledger;
    private SysUser createdBy;
    private LocalDateTime paidAt;
    /** Days before due date to start reminding (default 3) */
    private Integer remindBefore;
    /** NONE | WEEKLY | MONTHLY | YEARLY */
    private String repeatType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
