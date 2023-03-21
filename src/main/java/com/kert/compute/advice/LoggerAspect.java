package com.kert.compute.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Pointcut("execution(* com.kert.compute.service.*Service.*(..))")
    public void point(){}

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("====================================================around");
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        long start = System.currentTimeMillis();
        Signature methodName = joinPoint.getSignature();
        logger.debug("{}入参：{}",methodName,joinPoint.getArgs());
        Object proceed = joinPoint.proceed();
        logger.debug("{}出参：{}",methodName,proceed);
        logger.info("{}耗时{}ms",methodName,System.currentTimeMillis()-start);
        return proceed;
    }
}
