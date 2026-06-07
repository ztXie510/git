package com.example.ffms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Tag — flexible labels for tagging transactions.
 */
@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag extends IdEntity {

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 20)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ledger_id", nullable = false)
    private FamilyLedger ledger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private SysUser createdBy;
}
