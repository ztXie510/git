package me.spring.scheduler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 定时任务管理接口
 */
public interface TaskScheduleService {

    /**
     * 创建定时任务
     */
    String createTask(ScheduledTask task);

    /**
     * 更新定时任务
     */
    boolean updateTask(String taskId, ScheduledTask task);

    /**
     * 删除定时任务
     */
    boolean deleteTask(String taskId);

    /**
     * 启动定时任务
     */
    boolean startTask(String taskId);

    /**
     * 停止定时任务
     */
    boolean stopTask(String taskId);

    /**
     * 获取任务详情
     */
    ScheduledTask getTask(String taskId);

    /**
     * 获取所有任务
     */
    List<ScheduledTask> getAllTasks();

    /**
     * 获取运行中的任务
     */
    List<ScheduledTask> getRunningTasks();

    /**
     * 获取任务执行历史
     */
    List<TaskExecution> getTaskHistory(String taskId, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 立即执行任务
     */
    boolean executeTaskNow(String taskId, Map<String, Object> params);

    /**
     * 暂停任务
     */
    boolean pauseTask(String taskId);

    /**
     * 恢复任务
     */
    boolean resumeTask(String taskId);
}

/**
 * 任务执行监控接口
 */
public interface TaskExecutionMonitor {

    /**
     * 记录任务开始执行
     */
    void recordTaskStart(String taskId, String instanceId, Map<String, Object> params);

    /**
     * 记录任务执行进度
     */
    void recordTaskProgress(String taskId, String instanceId, int progress, String message);

    /**
     * 记录任务执行完成
     */
    void recordTaskCompletion(String taskId, String instanceId, TaskResult result);

    /**
     * 记录任务执行异常
     */
    void recordTaskException(String taskId, String instanceId, Exception e);

    /**
     * 获取任务执行状态
     */
    TaskExecutionStatus getExecutionStatus(String taskId, String instanceId);

    /**
     * 获取任务执行日志
     */
    List<TaskExecutionLog> getExecutionLogs(String taskId, String instanceId);

    /**
     * 获取任务性能统计
     */
    TaskPerformanceStats getPerformanceStats(String taskId, LocalDateTime startTime, LocalDateTime endTime);
}

/**
 * 任务依赖管理接口
 */
public interface TaskDependencyService {

    /**
     * 添加任务依赖
     */
    void addDependency(String taskId, String dependsOnTaskId);

    /**
     * 移除任务依赖
     */
    void removeDependency(String taskId, String dependsOnTaskId);

    /**
     * 获取任务依赖关系
     */
    List<String> getTaskDependencies(String taskId);

    /**
     * 获取依赖该任务的所有任务
     */
    List<String> getDependentTasks(String taskId);

    /**
     * 检查任务是否可以执行
     */
    boolean canExecuteTask(String taskId);

    /**
     * 获取执行顺序
     */
    List<String> getExecutionOrder(List<String> taskIds);

    /**
     * 循环依赖检查
     */
    boolean hasCircularDependency(String taskId);
}