package me.spring.service;

public interface SysLogService {
    void saveLog(String username, String operation, String method, String params,
                 String ip, long duration, String resultStatus);
}
