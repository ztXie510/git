package me.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

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
