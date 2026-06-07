package me.spring.notification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 通知模板管理接口
 */
public interface NotificationTemplateService {

    /**
     * 获取通知模板
     */
    String getTemplate(String templateCode);

    /**
     * 保存通知模板
     */
    void saveTemplate(String templateCode, String templateContent, String description);

    /**
     * 删除通知模板
     */
    void deleteTemplate(String templateCode);

    /**
     * 获取所有模板列表
     */
    List<NotificationTemplate> getAllTemplates();

    /**
     * 渲染模板
     */
    String renderTemplate(String templateCode, Map<String, Object> params);
}

/**
 * 通知发送服务接口
 */
public interface NotificationSendService {

    /**
     * 发送邮件通知
     */
    void sendEmailNotification(String to, String subject, String content);

    /**
     * 发送站内通知
     */
    void sendInternalNotification(Integer userId, String title, String content);

    /**
     * 发送短信通知
     */
    void sendSmsNotification(String phoneNumber, String content);

    /**
     * 发送应用推送
     */
    void sendPushNotification(Integer userId, String title, String content);

    /**
     * 批量发送通知
     */
    void sendBatchNotifications(List<NotificationRequest> requests);
}

/**
 * 定时通知服务接口
 */
public interface NotificationScheduleService {

    /**
     * 定时发送账单提醒
     */
    void sendBillReminders();

    /**
     * 定时发送预算预警
     */
    void sendBudgetWarnings();

    /**
     * 定时发送报表通知
     */
    void sendReportNotifications();

    /**
     * 添加定时通知
     */
    void scheduleNotification(String cronExpression, NotificationRequest request);

    /**
     * 取消定时通知
     */
    void cancelScheduledNotification(String scheduleId);
}

/**
 * 通知偏好设置接口
 */
public interface NotificationPreferenceService {

    /**
     * 获取用户通知偏好
     */
    NotificationPreference getUserPreference(Integer userId);

    /**
     * 更新用户通知偏好
     */
    void updateUserPreference(Integer userId, NotificationPreference preference);

    /**
     * 获取启用的通知类型
     */
    List<String> getEnabledNotificationTypes(Integer userId);

    /**
     * 检查是否允许发送某类型通知
     */
    boolean isNotificationAllowed(Integer userId, String notificationType);
}