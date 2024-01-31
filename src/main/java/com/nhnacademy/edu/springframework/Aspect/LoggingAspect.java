package com.nhnacademy.edu.springframework.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {

    private void messageSendPointCut() {}

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
