package me.spring.dao;

import me.spring.entity.TransactionTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionTagRepository extends JpaRepository<TransactionTag, Integer> {
    List<TransactionTag> findByTransaction_Id(Integer transactionId);
    List<TransactionTag> findByTag_Id(Integer tagId);
    void deleteByTransaction_Id(Integer transactionId);
}
