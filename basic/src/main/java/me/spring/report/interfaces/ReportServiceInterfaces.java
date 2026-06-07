package me.spring.report;

import me.spring.vo.ChartDataVO;
import me.spring.vo.ExportFileVO;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 报表数据缓存接口
 */
public interface ReportCacheService {

    /**
     * 缓存报表数据
     */
    void cacheReportData(String reportType, String cacheKey, Object data);

    /**
     * 获取缓存的报表数据
     */
    <T> T getCachedReportData(String reportType, String cacheKey, Class<T> type);

    /**
     * 清除报表缓存
     */
    void clearReportCache(String reportType, String cacheKey);

    /**
     * 获取报表缓存键
     */
    String getReportCacheKey(String reportType, Map<String, Object> params);
}

/**
 * 报表生成任务接口
 */
public interface ReportScheduleService {

    /**
     * 生成日报表
     */
    void generateDailyReports();

    /**
     * 生成周报表
     */
    void generateWeeklyReports();

    /**
     * 生成月报表
     */
    void generateMonthlyReports();

    /**
     * 生成自定义报表
     */
    void generateCustomReport(LocalDate startDate, LocalDate endDate, String reportType);
}

/**
 * 报表模板管理接口
 */
public interface ReportTemplateService {

    /**
     * 获取报表模板
     */
    String getReportTemplate(String templateName);

    /**
     * 保存报表模板
     */
    void saveReportTemplate(String templateName, String templateContent);

    /**
     * 删除报表模板
     */
    void deleteReportTemplate(String templateName);

    /**
     * 获取所有模板列表
     */
    List<String> getAllTemplateNames();
}

/**
 * 报表导出服务接口
 */
public interface ReportExportService {

    /**
     * 导出报表为Excel
     */
    ExportFileVO exportToExcel(String reportType, Map<String, Object> params);

    /**
     * 导出报表为PDF
     */
    ExportFileVO exportToPdf(String reportType, Map<String, Object> params);

    /**
     * 导出报表为CSV
     */
    ExportFileVO exportToCsv(String reportType, Map<String, Object> params);

    /**
     * 批量导出多个报表
     */
    List<ExportFileVO> batchExportReports(List<ReportExportRequest> requests);
}