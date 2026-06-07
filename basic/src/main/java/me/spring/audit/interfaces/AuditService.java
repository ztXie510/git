package me.spring.audit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 审计日志记录接口
 */
public interface AuditLogService {

    /**
     * 记录操作日志
     */
    void recordOperationLog(OperationLog log);

    /**
     * 记录数据变更日志
     */
    void recordDataChangeLog(DataChangeLog log);

    /**
     * 记录登录日志
     */
    void recordLoginLog(LoginLog log);

    /**
     * 记录API调用日志
     */
    void recordApiLog(ApiLog log);

    /**
     * 记录安全事件日志
     */
    void recordSecurityEventLog(SecurityEventLog log);

    /**
     * 查询操作日志
     */
    List<OperationLog> queryOperationLogs(OperationLogQuery query);

    /**
     * 查询数据变更日志
     */
    List<DataChangeLog> queryDataChangeLogs(DataChangeLogQuery query);

    /**
     * 查询登录日志
     */
    List<LoginLog> queryLoginLogs(LoginLogQuery query);

    /**
     * 查询API调用日志
     */
    List<ApiLog> queryApiLogs(ApiLogQuery query);

    /**
     * 查询安全事件日志
     */
    List<SecurityEventLog> querySecurityEventLogs(SecurityEventLogQuery query);

    /**
     * 获取审计统计
     */
    AuditStats getAuditStats(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 导出审计日志
     */
    byte[] exportAuditLogs(AuditLogQuery query, ExportFormat format);
}

/**
 * 审计分析接口
 */
public interface AuditAnalysisService {

    /**
     * 用户行为分析
     */
    UserBehaviorAnalysis analyzeUserBehavior(Integer userId, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 异常操作检测
     */
    List<AbnormalOperation> detectAbnormalOperations(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 敏感操作审计
     */
    List<SensitiveOperation> auditSensitiveOperations(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 权限变更追踪
     */
    List<PermissionChange> trackPermissionChanges(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 生成审计报告
     */
    AuditReport generateAuditReport(LocalDateTime startTime, LocalDateTime endTime);
}

/**
 * 审计存储接口
 */
public interface AuditStorageService {

    /**
     * 存储审计日志
     */
    void storeAuditLog(AuditLog log);

    /**
     * 批量存储审计日志
     */
    void batchStoreAuditLogs(List<AuditLog> logs);

    /**
     * 获取审计日志
     */
    AuditLog getAuditLog(String logId);

    /**
     * 删除过期审计日志
     */
    void cleanExpiredLogs(LocalDateTime beforeDate);

    /**
     * 备份审计日志
     */
    void backupAuditLogs(LocalDateTime beforeDate, String backupPath);

    /**
     * 恢复审计日志
     */
    void restoreAuditLogs(String backupPath);
}