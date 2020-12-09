package com.example.lab6_aspect.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月18日 4:10 下午
 */
@Aspect
@Component
public class ControllerAspect {

    @Around("execution(* com.example.lab6_aspect.Controller.*.*(..))")
    public Object hanlder(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("切片开始");
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());
        Object obj= joinPoint.proceed();
        System.out.println("切片结束");
        return obj;
    }



}
