package me.spring.dao;

import me.spring.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findByLedger_Id(Integer ledgerId);
    List<Bill> findByStatusAndDueDateBefore(String status, LocalDate date);
    List<Bill> findByDueDateBetweenAndStatus(LocalDate start, LocalDate end, String status);
}
