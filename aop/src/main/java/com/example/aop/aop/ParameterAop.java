package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void before(JoinPoint joinPoint){

    }

}
