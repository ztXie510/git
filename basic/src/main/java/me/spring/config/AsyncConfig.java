package me.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Enables asynchronous method execution — used for non-blocking email sending.
 */
@Configuration
@EnableAsync
public class AsyncConfig {
}
