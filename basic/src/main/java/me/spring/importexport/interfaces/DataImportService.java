package me.spring.importexport;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

/**
 * 数据导入服务接口
 */
public interface DataImportService {

    /**
     * 导入交易数据
     */
    ImportResult importTransactions(Integer ledgerId, MultipartFile file, ImportConfig config);

    /**
     * 导入预算数据
     */
    ImportResult importBudgets(Integer ledgerId, MultipartFile file, ImportConfig config);

    /**
     * 导入账户数据
     */
    ImportResult importAccounts(Integer ledgerId, MultipartFile file, ImportConfig config);

    /**
     * 批量导入多个类型数据
     */
    Map<String, ImportResult> batchImportData(Integer ledgerId, Map<String, MultipartFile> files, ImportConfig config);

    /**
     * 验证导入数据
     */
    ImportValidationResult validateImportData(MultipartFile file, String dataType);

    /**
     * 获取导入模板
     */
    byte[] getImportTemplate(String dataType);
}

/**
 * 数据导出服务接口
 */
public interface DataExportService {

    /**
     * 导出交易数据
     */
    ExportResult exportTransactions(Integer ledgerId, ExportConfig config);

    /**
     * 导出预算数据
     */
    ExportResult exportBudgets(Integer ledgerId, ExportConfig config);

    /**
     * 导出账户数据
     */
    ExportResult exportAccounts(Integer ledgerId, ExportConfig config);

    /**
     * 导出所有数据
     */
    ExportResult exportAllData(Integer ledgerId, ExportConfig config);

    /**
     * 导出数据报表
     */
    ExportResult exportDataReport(Integer ledgerId, ReportConfig reportConfig);
}

/**
 * 进度跟踪服务接口
 */
public interface ProgressTrackingService {

    /**
     * 开始导入任务
     */
    ImportProgress startImportTask(String taskId, String userId, String dataType);

    /**
     * 更新导入进度
     */
    void updateProgress(String taskId, int processedCount, int totalCount, String status);

    /**
     * 获取导入进度
     */
    ImportProgress getImportProgress(String taskId);

    /**
     * 完成导入任务
     */
    void completeImportTask(String taskId, ImportResult result);

    /**
     * 取消导入任务
     */
    void cancelImportTask(String taskId);
}