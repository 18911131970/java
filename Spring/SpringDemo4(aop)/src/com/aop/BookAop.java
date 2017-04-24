package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by yangzhe on 2017/4/24.
 */
@Aspect
public class BookAop {

    @Before(value = "execution(* com.aop.Book.*(..))")
    public void before(){
        System.out.println("BookAop------before 前置增强");
    }

    @After(value = "execution(* com.aop.Book.*(..))")
    public void after(){
        System.out.println("BookAop------after 后置增强");
    }

    @Around(value = "execution(* com.aop.Book.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("BookAop------around 之前");

        proceedingJoinPoint.proceed();

        System.out.println("BookAop------around 之后");
    }
}
