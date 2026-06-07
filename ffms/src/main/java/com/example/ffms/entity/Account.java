package com.example.ffms.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Payment account — bank card, Alipay, WeChat, cash, etc.
 */
@Entity
@Table(name = "account")
@Getter
@Setter
public class Account extends IdEntity {

    @Column(nullable = false, length = 50)
    private String name;

    /** CASH | BANK_CARD | CREDIT_CARD | ALIPAY | WECHAT | OTHER */
    @Column(nullable = false, length = 20)
    private String type;

    @Column(precision = 15, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(length = 10)
    private String currency = "CNY";

    @Column(length = 50)
    private String icon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ledger_id", nullable = false)
    private FamilyLedger ledger;

    @Column(nullable = false)
    private Boolean isActive = true;

    private Integer sortOrder;
}
