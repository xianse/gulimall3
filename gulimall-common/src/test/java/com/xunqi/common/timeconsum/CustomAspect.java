package com.xunqi.common.timeconsum;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.reflect.Method;

@Aspect
@Component
public class CustomAspect {

    private final Logger logger= LoggerFactory.getLogger(CustomAspect.class.getName());

    private final ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    @Pointcut("@annotation(com.xunqi.common.timeconsum.TimeRecord)")
    public void fun(){

    }

    @Before("fun()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        Method method=methodSignature.getMethod();

        TimeRecord timeRecord=method.getAnnotation(TimeRecord.class);
        if (timeRecord!=null){
            threadLocal.set(System.currentTimeMillis());
        }
    }

    @After(("fun()"))
    public void after(JoinPoint joinPoint){
        Method method=((MethodSignature)joinPoint.getSignature()).getMethod();

        TimeRecord timeRecord=method.getAnnotation(TimeRecord.class);
        if (timeRecord!=null){
            Long startTime=threadLocal.get();
            Long endTime=System.currentTimeMillis();
            Long costTime=endTime-startTime;

            String requestUri=method.getAnnotation(RequestMapping.class).value()[0];
            String methodName=method.getDeclaringClass().getName()+"."+method.getName();
            String methodDesc=timeRecord.methodDesc();

            logger.info("requestUri({}) methodName({}) methodDesc({}) ==> 花费时间 {}ms",requestUri,methodName,methodDesc,costTime);
        }
    }
}