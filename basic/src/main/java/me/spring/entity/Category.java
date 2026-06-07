package me.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Income/expense category — supports hierarchical parent-child subcategories.
 */
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category extends IdEntity {

    @Column(nullable = false, length = 50)
    private String name;

    /** INCOME | EXPENSE */
    @Column(nullable = false, length = 10)
    private String type;

    @Column(length = 50)
    private String icon;

    /** Self-referencing parent category for subcategories */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @Column(length = 20)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ledger_id", nullable = false)
    private FamilyLedger ledger;

    private Integer sortOrder;

    /** Whether this is a system-default category */
    @Column(nullable = false)
    private Boolean isSystem = false;
}
