package me.spring.dao;

import me.spring.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    List<Budget> findByLedger_Id(Integer ledgerId);
    Optional<Budget> findByLedger_IdAndCategory_Id(Integer ledgerId, Integer categoryId);
}
