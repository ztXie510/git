package com.example.ffms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Fixed bill — credit card, mortgage, rent, utilities with recurring reminders.
 */
@Entity
@Table(name = "bill")
@Getter
@Setter
public class Bill extends IdEntity {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate dueDate;

    /** CREDIT_CARD | MORTGAGE | CAR_LOAN | RENT | UTILITY | OTHER */
    @Column(nullable = false, length = 30)
    private String billType;

    /** PENDING | PAID | OVERDUE */
    @Column(nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ledger_id", nullable = false)
    private FamilyLedger ledger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private SysUser createdBy;

    private LocalDateTime paidAt;

    /** Days before due date to start reminding (default 3) */
    private Integer remindBefore;

    /** NONE | WEEKLY | MONTHLY | YEARLY */
    @Column(length = 20)
    private String repeatType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) status = "PENDING";
        if (remindBefore == null) remindBefore = 3;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
