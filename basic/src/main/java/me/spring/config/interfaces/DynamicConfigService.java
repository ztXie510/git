package me.spring.config;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 动态配置管理接口
 */
public interface DynamicConfigService {

    /**
     * 获取配置值
     */
    <T> T getConfig(String key, Class<T> type);

    /**
     * 获取配置值，带默认值
     */
    <T> T getConfig(String key, Class<T> type, T defaultValue);

    /**
     * 设置配置值
     */
    void setConfig(String key, Object value, String description);

    /**
     * 删除配置
     */
    void deleteConfig(String key);

    /**
     * 获取所有配置
     */
    List<DynamicConfig> getAllConfigs();

    /**
     * 按分类获取配置
     */
    List<DynamicConfig> getConfigsByCategory(String category);

    /**
     * 模糊查询配置
     */
    List<DynamicConfig> searchConfigs(String keyword);

    /**
     * 获取配置变更历史
     */
    List<ConfigHistory> getConfigHistory(String key);

    /**
     * 导出配置
     */
    byte[] exportConfigs();

    /**
     * 导入配置
     */
    void importConfigs(byte[] data);
}

/**
 * 配置版本控制接口
 */
public interface ConfigVersionService {

    /**
     * 创建配置版本
     */
    String createVersion(String configKey, Object oldValue, Object newValue, String reason);

    /**
     * 获取配置版本历史
     */
    List<ConfigVersion> getVersionHistory(String configKey);

    /**
     * 回滚到指定版本
     */
    boolean rollbackToVersion(String configKey, String version);

    /**
     * 比较两个版本
     */
    ConfigDiff compareVersions(String configKey, String version1, String version2);

    /**
     * 标记版本
     */
    void tagVersion(String configKey, String version, String tagName);
}

/**
 * 配置热更新接口
 */
public interface ConfigRefreshService {

    /**
     * 刷新配置缓存
     */
    void refreshCache(String configKey);

    /**
     * 监听配置变化
     */
    void watchConfigChange(String configKey, ConfigChangeListener listener);

    /**
     * 取消监听配置变化
     */
    void unwatchConfigChange(String configKey, ConfigChangeListener listener);

    /**
     * 广播配置变更
     */
    void broadcastConfigChange(String configKey, Object newValue);

    /**
     * 获取配置更新事件
     */
    List<ConfigChangeEvent> getConfigChangeEvents(LocalDateTime startTime, LocalDateTime endTime);
}