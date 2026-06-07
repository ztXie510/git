package me.spring.cache;

import java.util.List;
import java.util.Map;

/**
 * 请求缓存服务接口
 */
public interface RequestCacheService {

    /**
     * 缓存请求结果
     */
    void cacheResult(String cacheKey, Object result, long ttlSeconds);

    /**
     * 获取缓存结果
     */
    <T> T getCachedResult(String cacheKey, Class<T> type);

    /**
     * 删除缓存
     */
    void evictCache(String cacheKey);

    /**
     * 清空所有缓存
     */
    void clearAllCache();

    /**
     * 检查缓存是否存在
     */
    boolean isCached(String cacheKey);

    /**
     * 获取缓存统计信息
     */
    CacheStats getCacheStats();

    /**
     * 批量获取缓存结果
     */
    <T> Map<String, T> batchGetCache(List<String> cacheKeys, Class<T> type);
}

/**
 * 多级缓存接口
 */
public interface MultiLevelCacheService {

    /**
     * 从多级缓存获取数据
     */
    <T> T getFromMultiLevelCache(String cacheKey, Class<T> type, CacheLevel level);

    /**
     * 存储到多级缓存
     */
    void putToMultiLevelCache(String cacheKey, Object value, CacheLevel level, long ttlSeconds);

    /**
     * 缓存穿透保护
     */
    <T> T getWithPenetrationProtection(String cacheKey, Class<T> type, CacheLoader loader);

    /**
     * 缓存雪崩保护
     */
    <T> T getWithAvalancheProtection(String cacheKey, Class<T> type, CacheLoader loader);

    /**
     * 缓存击穿保护
     */
    <T> T getWithBreakdownProtection(String cacheKey, Class<T> type, CacheLoader loader);

    /**
     * 预热缓存
     */
    void warmUpCache(List<String> cacheKeys, CacheLoader loader);
}

/**
 * 分布式锁接口
 */
public interface DistributedLockService {

    /**
     * 获取锁
     */
    boolean acquireLock(String lockKey, long leaseTime);

    /**
     * 释放锁
     */
    boolean releaseLock(String lockKey);

    /**
     * 尝试获取锁
     */
    boolean tryAcquireLock(String lockKey, long waitTime, long leaseTime);

    /**
     * 获取锁信息
     */
    LockInfo getLockInfo(String lockKey);

    /**
     * 锁续期
     */
    boolean renewLock(String lockKey, long newLeaseTime);

    /**
     * 获取锁等待时间
     */
    long getLockWaitTime(String lockKey);
}