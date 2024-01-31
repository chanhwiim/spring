package com.nhnacademy.edu.springframework.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(boolean com.nhnacademy.edu.springframework.service.impl.DoorayMessageSender.sendMessage(..))")
    private void messageSendPointCut() {}

    @Around("messageSendPointCut()")
    public Object doMessageProfiling (ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try{
            return pjp.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            stopWatch.stop();
            System.out.println(pjp.getSignature().toShortString() + " : " + stopWatch.getTotalTimeMillis() + " ms");
        }
    }

}
