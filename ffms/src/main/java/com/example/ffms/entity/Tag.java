package com.example.ffms.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Tag — flexible labels for tagging transactions.
 */
@Getter
@Setter
public class Tag extends IdEntity {

    private String name;
    private String color;
    private FamilyLedger ledger;
    private SysUser createdBy;
}
