package me.spring.websocket;

import java.util.List;
import java.util.Map;

/**
 * WebSocket连接管理接口
 */
public interface WebSocketConnectionService {

    /**
     * 建立WebSocket连接
     */
    String connect(String userId, String sessionId);

    /**
     * 断开WebSocket连接
     */
    void disconnect(String sessionId);

    /**
     * 获取连接信息
     */
    ConnectionInfo getConnectionInfo(String sessionId);

    /**
     * 获取用户所有连接
     */
    List<ConnectionInfo> getUserConnections(String userId);

    /**
     * 检查连接状态
     */
    boolean isConnectionActive(String sessionId);

    /**
     * 获取在线用户列表
     */
    List<String> getOnlineUsers();

    /**
     * 获取连接统计
     */
    ConnectionStats getConnectionStats();
}

/**
 * WebSocket消息服务接口
 */
public interface WebSocketMessageService {

    /**
     * 发送单播消息
     */
    void sendToUser(String userId, WebSocketMessage message);

    /**
     * 发送群播消息
     */
    void sendToUsers(List<String> userIds, WebSocketMessage message);

    /**
     * 发送广播消息
     */
    void broadcast(WebSocketMessage message);

    /**
     * 发送特定主题消息
     */
    void sendToTopic(String topic, WebSocketMessage message);

    /**
     * 发送系统消息
     */
    void sendSystemMessage(String userId, String content, Map<String, Object> data);

    /**
     * 发送通知消息
     */
    void sendNotification(String userId, String type, String title, String content);

    /**
     * 发送实时数据更新
     */
    void sendDataUpdate(String userId, String dataType, Object data);

    /**
     * 消息持久化
     */
    void persistMessage(WebSocketMessage message);
}

/**
 * WebSocket订阅管理接口
 */
public interface WebSocketSubscriptionService {

    /**
     * 订阅主题
     */
    void subscribe(String userId, String topic, SubscriptionCallback callback);

    /**
     * 取消订阅
     */
    void unsubscribe(String userId, String topic);

    /**
     * 获取用户订阅列表
     */
    List<String> getUserSubscriptions(String userId);

    /**
     * 获取主题订阅者
     */
    List<String> getTopicSubscribers(String topic);

    /**
     * 广播订阅消息
     */
    void broadcastToSubscribers(String topic, WebSocketMessage message);

    /**
     * 创建订阅组
     */
    String createSubscriptionGroup(String groupName, List<String> topics);

    /**
     * 向订阅组发送消息
     */
    void sendToGroup(String groupName, WebSocketMessage message);
}