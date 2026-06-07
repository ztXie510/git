package me.spring.mq;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 消息发送接口
 */
public interface MessageSenderService {

    /**
     * 发送同步消息
     */
    <T> MessageResult<T> sendSyncMessage(String topic, T message, Map<String, String> headers);

    /**
     * 发送异步消息
     */
    <T> MessageResult<T> sendAsyncMessage(String topic, T message, Map<String, String> headers);

    /**
     * 发送延迟消息
     */
    <T> MessageResult<T> sendDelayedMessage(String topic, T message, long delaySeconds, Map<String, String> headers);

    /**
     * 发送事务消息
     */
    <T> MessageResult<T> sendTransactionalMessage(String topic, T message, Map<String, String> headers, TransactionalCallback callback);

    /**
     * 批量发送消息
     */
    <T> List<MessageResult<T>> batchSendMessages(String topic, List<T> messages, Map<String, String> headers);

    /**
     * 广播消息
     */
    <T> void broadcastMessage(String topic, T message, Map<String, String> headers);
}

/**
 * 消息消费接口
 */
public interface MessageConsumerService {

    /**
     * 注册消息监听器
     */
    void registerListener(String topic, MessageListener listener);

    /**
     * 取消消息监听器
     */
    void unregisterListener(String topic, MessageListener listener);

    /**
     * 开始消费
     */
    void startConsuming(String topic);

    /**
     * 停止消费
     */
    void stopConsuming(String topic);

    /**
     * 获取消费状态
     */
    ConsumerStatus getConsumerStatus(String topic);

    /**
     * 重试失败消息
     */
    void retryFailedMessages(String topic, int retryCount);
}

/**
 * 消息追踪接口
 */
public interface MessageTraceService {

    /**
     * 记录消息发送
     */
    void recordMessageSend(MessageRecord record);

    /**
     * 记录消息接收
     */
    void recordMessageReceive(MessageRecord record);

    /**
     * 记录消息处理完成
     */
    void recordMessageComplete(MessageRecord record);

    /**
     * 记录消息处理异常
     */
    void recordMessageError(MessageRecord record, Exception e);

    /**
     * 获取消息轨迹
     */
    MessageTrace getTrace(String messageId);

    /**
     * 获取消息状态
     */
    MessageStatus getMessageStatus(String messageId);

    /**
     * 获取失败消息列表
     */
    List<MessageRecord> getFailedMessages(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 重新发送失败消息
     */
    void resendFailedMessages(List<String> messageIds);
}