package me.spring.ratelimit;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 限流器接口
 */
public interface RateLimiter {

    /**
     * 尝试获取许可
     */
    boolean tryAcquire(String key);

    /**
     * 尝试获取许可，等待指定时间
     */
    boolean tryAcquire(String key, long waitTime, TimeUnit unit);

    /**
     * 获取许可（阻塞）
     */
    void acquire(String key) throws InterruptedException;

    /**
     * 获取剩余许可数
     */
    int getRemainingPermits(String key);

    /**
     * 获取等待时间
     */
    long getWaitTime(String key);

    /**
     * 重置限流器
     */
    void reset(String key);

    /**
     * 设置限流规则
     */
    void setRateLimitRule(String key, RateLimitRule rule);

    /**
     * 获取限流规则
     */
    RateLimitRule getRateLimitRule(String key);
}

/**
 * 分布式限流器接口
 */
public interface DistributedRateLimiter {

    /**
     * 尝试获取许可
     */
    boolean tryAcquire(String key, String clientId);

    /**
     * 尝试获取许可，等待指定时间
     */
    boolean tryAcquire(String key, String clientId, long waitTime, TimeUnit unit);

    /**
     * 获取剩余许可数
     */
    int getRemainingPermits(String key, String clientId);

    /**
     * 获取限流统计
     */
    RateLimitStats getStats(String key, String clientId);

    /**
     * 设置限流规则
     */
    void setRateLimitRule(String key, String clientId, DistributedRateLimitRule rule);

    /**
     * 获取限流规则
     */
    DistributedRateLimitRule getRateLimitRule(String key, String clientId);
}

/**
 * 限流规则服务接口
 */
public interface RateLimitRuleService {

    /**
     * 创建限流规则
     */
    String createRule(RateLimitRule rule);

    /**
     * 更新限流规则
     */
    boolean updateRule(String ruleId, RateLimitRule rule);

    /**
     * 删除限流规则
     */
    boolean deleteRule(String ruleId);

    /**
     * 获取限流规则
     */
    RateLimitRule getRule(String ruleId);

    /**
     * 获取所有规则
     */
    List<RateLimitRule> getAllRules();

    /**
     * 启用/禁用规则
     */
    boolean toggleRule(String ruleId, boolean enabled);

    /**
     * 获取规则使用统计
     */
    RuleUsageStats getRuleUsageStats(String ruleId, LocalDateTime startTime, LocalDateTime endTime);
}