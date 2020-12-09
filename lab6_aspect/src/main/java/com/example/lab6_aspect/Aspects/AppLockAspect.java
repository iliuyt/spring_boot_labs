package com.example.lab6_aspect.Aspects;

import com.example.lab6_aspect.annotation.AppLock;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月18日 4:10 下午
 */
@Aspect
@Component
public class AppLockAspect {

    @Pointcut("@annotation(com.example.lab6_aspect.annotation.AppLock)")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void appLock(JoinPoint joinPoint) throws Throwable {
        // 获取注解
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method currentMethod = joinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        AppLock appLockAnnotation = currentMethod.getAnnotation(AppLock.class);
        Integer argIndex = appLockAnnotation.argIndex();

        // 校验注解参数个数
        if (joinPoint.getArgs().length > argIndex) {
            Object checkArgs = joinPoint.getArgs()[argIndex];
            Method appCodeMethod = checkArgs.getClass().getMethod(appLockAnnotation.getAppCode());
            String appCode = appCodeMethod.invoke(checkArgs).toString();
            Method appTypeMethod = checkArgs.getClass().getMethod(appLockAnnotation.getAppType());
            String appType = appTypeMethod.invoke(checkArgs).toString();
            if ("lab6".equals(appCode) && "test".equals(appType)) {
                throw new Exception("App 被锁定");
            }
        }
    }

}
