package me.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Budget — monthly spending limit, tracked per category or globally.
 */
@Entity
@Table(name = "budget")
@Getter
@Setter
public class Budget extends IdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(precision = 15, scale = 2)
    private BigDecimal spent = BigDecimal.ZERO;

    /** MONTHLY | YEARLY | CUSTOM */
    @Column(nullable = false, length = 20)
    private String periodType;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ledger_id", nullable = false)
    private FamilyLedger ledger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private SysUser createdBy;

    /** Alert threshold as percentage (e.g., 0.80 = 80%) */
    @Column(precision = 3, scale = 2)
    private BigDecimal alertThreshold;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (alertThreshold == null) alertThreshold = new BigDecimal("0.80");
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
