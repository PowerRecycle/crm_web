package com.crazycode.advise;

import com.crazycode.pojo.Syslog;
import com.crazycode.pojo.Users;
import com.crazycode.service.SyslogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * 创建一个切面(通知+切入点的组合)
 * 切入点（Pointcut） 具体被增强的方法
 * 增强(通知)（Advise）带有增强功方法的类就叫通知类
 */
@Aspect
@Component
public class LogAdvise {
    @Autowired
    private SyslogService syslogService;
    private Long startTime;
    private Long endTime;

    @Pointcut("execution(* com.crazycode.controller..*.*(..))")
    public void p1() {
    }

    @Before("p1()")
    public void before() throws Exception {
        System.out.println("前置通知[Before advice]：在业务方法之前执行的功能");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("开始日志记录....");
        startTime = System.currentTimeMillis();
    }

    @AfterReturning("p1()")
    public void afterReturning(JoinPoint joinPoint) throws Exception {
        System.out.println("后置通知[After returning advice]：在业务方法执行完毕后要执行的功能");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        endTime = System.currentTimeMillis();
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            Syslog syslog = new Syslog();
            syslog.setVisitTime((new Timestamp(System.currentTimeMillis())).toString());
            syslog.setUsername(user.getUsername());
            syslog.setIp(request.getRemoteAddr());
            syslog.setUrl(request.getRequestURI());
            syslog.setExecutionTime(endTime - startTime);
            syslog.setMethod(joinPoint.getSignature().getName());
            System.out.println(syslog);
            syslogService.addSyslog(syslog);
        }
        System.out.println("日志记录完毕....");

    }

    @After("p1()")
    public void after() throws Exception {
        System.out.println("最终通知[After advice]: 业务方法执行的过程中不管有没有异常都要执行的功能");
        System.out.println("释放日志资源....");
    }

    /*@AfterThrowing("p1()")
    public void AfterThrowing() throws Exception {
        System.out.println("异常通知[After throwing advice]]:在业务方法抛出异常的时候要执行的功能");
        System.out.println("日志记录异常信息....");
    }*/
}
