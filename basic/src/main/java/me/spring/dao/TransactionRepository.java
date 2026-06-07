package me.spring.dao;

import me.spring.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByLedger_IdAndTransactionDateBetween(
        Integer ledgerId, LocalDateTime start, LocalDateTime end);
    List<Transaction> findByLedger_IdAndCategory_Id(Integer ledgerId, Integer categoryId);
    List<Transaction> findByLedger_IdAndCreatedBy_Id(Integer ledgerId, Integer userId);
    List<Transaction> findByLedger_IdAndAccount_Id(Integer ledgerId, Integer accountId);
}
