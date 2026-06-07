package me.spring.version;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * API版本管理接口
 */
public interface ApiVersionService {

    /**
     * 获取API版本信息
     */
    ApiVersionInfo getApiVersion(String apiPath, String version);

    /**
     * 注册API版本
     */
    String registerApiVersion(ApiVersion version);

    /**
     * 更新API版本
     */
    boolean updateApiVersion(String versionId, ApiVersion version);

    /**
     * 废弃API版本
     */
    boolean deprecateApiVersion(String versionId, String deprecationMessage);

    /**
     * 获取所有API版本
     */
    List<ApiVersion> getAllApiVersions();

    /**
     * 获取API历史版本
     */
    List<ApiVersion> getApiHistory(String apiPath);

    /**
     * 版本兼容性检查
     */
    VersionCompatibility checkCompatibility(String version1, String version2);

    /**
     * API迁移指导
     */
    ApiMigrationGuide getMigrationGuide(String fromVersion, String toVersion);
}

/**
 * API文档生成接口
 */
public interface ApiDocService {

    /**
     * 生成Swagger文档
     */
    String generateSwaggerDoc(String apiPath, String version);

    /**
     * 生成OpenAPI文档
     */
    String generateOpenApiDoc(String apiPath, String version);

    /**
     * 生成HTML文档
     */
    String generateHtmlDoc(String apiPath, String version);

    /**
     * 生成PDF文档
     */
    byte[] generatePdfDoc(String apiPath, String version);

    /**
     * 获取API变更日志
     */
    List<ApiChangeLog> getApiChangeLog(String apiPath, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 创建API文档模板
     */
    String createDocTemplate(String templateName, String templateContent);

    /**
     * 更新API文档模板
     */
    boolean updateDocTemplate(String templateId, String templateContent);
}

/**
 * API兼容性分析接口
 */
public interface ApiCompatibilityService {

    /**
     * 分析API兼容性
     */
    CompatibilityAnalysis analyzeCompatibility(String apiPath, List<String> versions);

    /**
     * 检查破坏性变更
     */
    List<BreakingChange> checkBreakingChanges(String fromVersion, String toVersion);

    /**
     * 生成兼容性报告
     */
    CompatibilityReport generateCompatibilityReport(String apiPath, String fromVersion, String toVersion);

    /**
     * 获取API使用统计
     */
    ApiUsageStats getUsageStats(String apiPath, String version, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 预测API迁移影响
     */
    MigrationImpact predictMigrationImpact(String fromVersion, String toVersion);
}