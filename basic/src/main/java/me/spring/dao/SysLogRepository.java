package me.spring.dao;

import me.spring.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SysLogRepository extends JpaRepository<SysLog, Integer> {
    List<SysLog> findByUsernameOrderByCreateTimeDesc(String username);
    List<SysLog> findByCreateTimeBetween(LocalDateTime start, LocalDateTime end);
}
