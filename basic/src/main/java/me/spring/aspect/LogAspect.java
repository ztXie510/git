package me.spring.aspect;

import jakarta.servlet.http.HttpServletRequest;
import me.spring.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * AOP aspect — intercepts @Log-annotated methods and records operation logs.
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(me.spring.annotation.Log)")
    public void logPointcut() {}

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        String resultStatus = "SUCCESS";

        try {
            return point.proceed();
        } catch (Throwable e) {
            resultStatus = "FAIL";
            throw e;
        } finally {
            long duration = System.currentTimeMillis() - start;

            MethodSignature signature = (MethodSignature) point.getSignature();
            String method = signature.getDeclaringTypeName() + "." + signature.getName();
            Log annotation = signature.getMethod().getAnnotation(Log.class);
            String operation = annotation.value().isEmpty() ? method : annotation.value();

            String ip = "unknown";
            ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attrs != null) {
                ip = attrs.getRequest().getRemoteAddr();
            }

            log.info("[AOP Log] op={}, method={}, ip={}, duration={}ms, status={}",
                operation, method, ip, duration, resultStatus);
            // TODO: persist to SysLog table via SysLogService
        }
    }
}
