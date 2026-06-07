package com.example.ffms.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Many-to-many association between ledger and user, with role in this ledger.
 * UNIQUE(ledger_id, user_id)
 */
@Getter
@Setter
public class LedgerMember extends IdEntity {

    private FamilyLedger ledger;
    private SysUser user;
    /** OWNER | ADMIN | MEMBER */
    private String role;
    private LocalDateTime joinedAt;
}
