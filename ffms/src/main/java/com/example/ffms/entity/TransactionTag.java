package com.example.ffms.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Many-to-many join table between Transaction and Tag.
 * UNIQUE(transaction_id, tag_id)
 */
@Getter
@Setter
public class TransactionTag extends IdEntity {

    private Transaction transaction;
    private Tag tag;
}
