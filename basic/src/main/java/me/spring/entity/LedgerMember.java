package me.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Many-to-many association between ledger and user, with role in this ledger.
 * UNIQUE(ledger_id, user_id)
 */
@Entity
@Table(name = "ledger_member",
       uniqueConstraints = @UniqueConstraint(columnNames = {"ledger_id", "user_id"}))
@Getter
@Setter
public class LedgerMember extends IdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ledger_id", nullable = false)
    private FamilyLedger ledger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private SysUser user;

    /** OWNER | ADMIN | MEMBER */
    @Column(nullable = false, length = 20)
    private String role;

    private LocalDateTime joinedAt;

    @PrePersist
    protected void onCreate() {
        joinedAt = LocalDateTime.now();
    }
}
