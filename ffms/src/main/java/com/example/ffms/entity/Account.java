package com.example.ffms.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * Payment account — bank card, Alipay, WeChat, cash, etc.
 */
@Getter
@Setter
public class Account extends IdEntity {

    private String name;
    /** CASH | BANK_CARD | CREDIT_CARD | ALIPAY | WECHAT | OTHER */
    private String type;
    private BigDecimal balance = BigDecimal.ZERO;
    private String currency = "CNY";
    private String icon;
    private FamilyLedger ledger;
    private Boolean isActive = true;
    private Integer sortOrder;
}
