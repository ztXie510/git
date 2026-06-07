package me.spring.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 报表模板数据访问层
 */
@Repository
public interface ReportTemplateRepository extends JpaRepository<ReportTemplate, Integer> {

    /**
     * 查找账本下的所有模板
     */
    List<ReportTemplate> findByLedgerId(Integer ledgerId);

    /**
     * 查找指定报表类型的模板
     */
    List<ReportTemplate> findByReportTypeAndLedgerId(String reportType, Integer ledgerId);

    /**
     * 查找默认模板
     */
    @Query("SELECT rt FROM ReportTemplate rt WHERE rt.ledgerId = :ledgerId AND rt.reportType = :reportType AND rt.isDefault = true")
    ReportTemplate findDefaultTemplate(Integer ledgerId, String reportType);

    /**
     * 按模板名称查询
     */
    ReportTemplate findByTemplateNameAndLedgerId(String templateName, Integer ledgerId);

    /**
     * 查找所有默认模板
     */
    @Query("SELECT rt FROM ReportTemplate rt WHERE rt.isDefault = true")
    List<ReportTemplate> findAllDefaultTemplates();
}