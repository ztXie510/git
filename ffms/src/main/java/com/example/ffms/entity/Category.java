package com.example.ffms.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Income/expense category — supports hierarchical parent-child subcategories.
 */
@Getter
@Setter
public class Category extends IdEntity {

    private String name;
    /** INCOME | EXPENSE */
    private String type;
    private String icon;
    /** Self-referencing parent category for subcategories */
    private Category parent;
    private String color;
    private FamilyLedger ledger;
    private Integer sortOrder;
    /** Whether this is a system-default category */
    private Boolean isSystem = false;
}
