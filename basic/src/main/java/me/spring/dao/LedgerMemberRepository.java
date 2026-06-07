package me.spring.dao;

import me.spring.entity.LedgerMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LedgerMemberRepository extends JpaRepository<LedgerMember, Integer> {
    List<LedgerMember> findByLedger_Id(Integer ledgerId);
    List<LedgerMember> findByUser_Id(Integer userId);
    Optional<LedgerMember> findByLedger_IdAndUser_Id(Integer ledgerId, Integer userId);
    long countByLedger_Id(Integer ledgerId);
}
