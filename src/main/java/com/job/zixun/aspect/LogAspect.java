package com.job.zixun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.job.zixun.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        for (Object arg : joinPoint.getArgs()) {
            sb.append("args:" + arg.toString() + "||");
        }
        logger.info("Before method: " + sb.toString());
    }

    @After("execution(* com.job.zixun.controller.IndexController.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        logger.info("After method: ");
    }

}
