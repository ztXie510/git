package com.example.ffms.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Family ledger — a shared financial data container for one family.
 */
@Getter
@Setter
public class FamilyLedger extends IdEntity {

    private String name;
    private String description;
    private SysUser createdBy;
    private Boolean isDefault = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
