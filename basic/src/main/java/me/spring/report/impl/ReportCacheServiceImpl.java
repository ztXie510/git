package me.spring.report.impl;

import me.spring.report.ReportCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;

/**
 * 报表数据缓存实现
 */
@Service
public class ReportCacheServiceImpl implements ReportCacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String REPORT_CACHE_PREFIX = "report:";
    private static final Duration DEFAULT_CACHE_DURATION = Duration.ofHours(1);

    @Override
    public void cacheReportData(String reportType, String cacheKey, Object data) {
        String key = REPORT_CACHE_PREFIX + reportType + ":" + cacheKey;
        redisTemplate.opsForValue().set(key, data, DEFAULT_CACHE_DURATION);
    }

    @Override
    public <T> T getCachedReportData(String reportType, String cacheKey, Class<T> type) {
        String key = REPORT_CACHE_PREFIX + reportType + ":" + cacheKey;
        Object data = redisTemplate.opsForValue().get(key);
        return type.cast(data);
    }

    @Override
    public void clearReportCache(String reportType, String cacheKey) {
        String key = REPORT_CACHE_PREFIX + reportType + ":" + cacheKey;
        redisTemplate.delete(key);
    }

    @Override
    public String getReportCacheKey(String reportType, Map<String, Object> params) {
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(reportType).append(":");
        params.forEach((k, v) -> {
            keyBuilder.append(k).append("=").append(v).append("&");
        });
        return keyBuilder.toString();
    }
}