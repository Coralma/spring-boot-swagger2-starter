package com.coral.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by ccc on 2017/11/6.
 */
@Aspect
@Order(5)
@Component
public class AopInterceptor {

    @Pointcut("execution(* com.coral.boot.controller..*.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Signature signature = joinPoint.getSignature();
        String invokeMethod = signature.getDeclaringTypeName() + "." +  signature.getName();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("Invoke " + invokeMethod + ", Take time : " + (end - start) + " ms!");
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            System.out.println("Invoke " + invokeMethod + ", Take time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)throws Throwable {
        Signature signature = joinPoint.getSignature();
        System.out.println("Call " + signature.getDeclaringTypeName() + "." +  signature.getName() );
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        Signature signature = joinPoint.getSignature();
        System.out.println("Return " + signature.getDeclaringTypeName() + "." +  signature.getName() + ", return value is " + ret);
    }

}
