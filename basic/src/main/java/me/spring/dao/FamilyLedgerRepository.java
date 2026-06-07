package me.spring.dao;

import me.spring.entity.FamilyLedger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyLedgerRepository extends JpaRepository<FamilyLedger, Integer> {
    List<FamilyLedger> findByCreatedBy_Id(Integer userId);
}
