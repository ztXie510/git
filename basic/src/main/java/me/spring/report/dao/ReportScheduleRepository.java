package me.spring.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 定时报表任务数据访问层
 */
@Repository
public interface ReportScheduleRepository extends JpaRepository<ReportSchedule, Integer> {

    /**
     * 查找账本下的所有启用的报表任务
     */
    @Query("SELECT rs FROM ReportSchedule rs WHERE rs.ledgerId = :ledgerId AND rs.enabled = true")
    List<ReportSchedule> findEnabledSchedulesByLedgerId(Integer ledgerId);

    /**
     * 查找需要执行的任务
     */
    @Query("SELECT rs FROM ReportSchedule rs WHERE rs.enabled = true AND rs.nextExecution <= :now ORDER BY rs.nextExecution ASC")
    List<ReportSchedule> findPendingTasks(LocalDateTime now);

    /**
     * 查找最近执行的任务
     */
    @Query("SELECT rs FROM ReportSchedule rs WHERE rs.ledgerId = :ledgerId ORDER BY rs.lastExecuted DESC")
    List<ReportSchedule> findLatestSchedules(Integer ledgerId, int limit);

    /**
     * 按报表类型查询
     */
    List<ReportSchedule> findByReportTypeAndLedgerId(String reportType, Integer ledgerId);
}