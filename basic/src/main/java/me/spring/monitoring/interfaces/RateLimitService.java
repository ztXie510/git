package me.spring.monitoring;

import java.time.LocalDateTime;
import java.util.List;

/**
 * API限流服务接口
 */
public interface RateLimitService {

    /**
     * 检查是否允许请求
     */
    boolean allowRequest(String clientId, String endpoint, String userId);

    /**
     * 获取当前请求计数
     */
    int getCurrentCount(String clientId, String endpoint);

    /**
     * 重置请求计数
     */
    void resetCount(String clientId, String endpoint);

    /**
     * 设置限流规则
     */
    void setRateLimitRule(String endpoint, RateLimitRule rule);

    /**
     * 获取限流规则
     */
    RateLimitRule getRateLimitRule(String endpoint);

    /**
     * 获取客户端限流统计
     */
    RateLimitStats getClientStats(String clientId, String endpoint);
}

/**
 * API监控服务接口
 */
public interface ApiMonitorService {

    /**
     * 记录API调用
     */
    void recordApiCall(ApiCallRecord record);

    /**
     * 获取API调用统计
     */
    ApiCallStats getApiStats(String endpoint, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 获取慢查询列表
     */
    List<SlowQuery> getSlowQueries(LocalDateTime startTime, LocalDateTime endTime, int limit);

    /**
     * 获取异常API列表
     */
    List<ExceptionApi> getExceptionApis(LocalDateTime startTime, LocalDateTime endTime, int limit);

    /**
     * 获取实时API性能指标
     */
    ApiMetrics getRealTimeMetrics();

    /**
     * 设置异常阈值
     */
    void setAlertThreshold(String metric, double threshold);

    /**
     * 检查是否需要报警
     */
    boolean shouldAlert(String metric, double value);
}

/**
 * 性能指标收集服务接口
 */
public interface MetricsCollectionService {

    /**
     * 记录性能指标
     */
    void recordMetric(String metricName, double value, Map<String, String> tags);

    /**
     * 获取性能指标数据
     */
    List<MetricData> getMetricData(String metricName, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 生成性能报告
     */
    PerformanceReport generatePerformanceReport(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 设置聚合规则
     */
    void setAggregationRule(String metricName, AggregationType aggregationType, long interval);
}