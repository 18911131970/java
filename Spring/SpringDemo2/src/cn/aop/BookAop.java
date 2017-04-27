package cn.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by yangzhe on 2017/4/24.
 */
public class BookAop {

    public void before(){
        System.out.println("BookAop------before 前置增强");
    }

    public void after(){
        System.out.println("BookAop------after 后置增强");
    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("BookAop------around 之前");

        proceedingJoinPoint.proceed();

        System.out.println("BookAop------around 之后");
    }
}
