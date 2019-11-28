package com.crazycode.advise;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 创建一个切面(通知+切入点的组合)
 * 切入点（Pointcut） 具体被增强的方法
 * 增强(通知)（Advise）带有增强功方法的类就叫通知类
 */
@Aspect
@Component
public class LogAdvise {
    @Pointcut("execution(* com.crazycode.controller..*.*(..))")
    public void p1() {
    }

    @Before("p1()")
    public void before() throws Exception {
        System.out.println("前置通知[Before advice]：在业务方法之前执行的功能");
        System.out.println("开始日志记录....");
    }

    @AfterReturning("p1()")
    public void afterReturning() throws Exception {
        System.out.println("后置通知[After returning advice]：在业务方法执行完毕后要执行的功能");
        System.out.println("日志记录完毕....");
    }

    @After("p1()")
    public void after() throws Exception {
        System.out.println("最终通知[After advice]: 业务方法执行的过程中不管有没有异常都要执行的功能");
        System.out.println("释放日志资源....");
    }

    @AfterThrowing("p1()")
    public void AfterThrowing() throws Exception {
        System.out.println("异常通知[After throwing advice]]:在业务方法抛出异常的时候要执行的功能");
        System.out.println("日志记录异常信息....");
    }
}
