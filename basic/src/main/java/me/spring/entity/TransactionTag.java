package me.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Many-to-many join table between Transaction and Tag.
 */
@Entity
@Table(name = "transaction_tag",
       uniqueConstraints = @UniqueConstraint(columnNames = {"transaction_id", "tag_id"}))
@Getter
@Setter
public class TransactionTag extends IdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
