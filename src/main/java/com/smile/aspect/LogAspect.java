package com.smile.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志处理，使用springAOP
 * @Author: smile
 * @Date: 2020/1/20
 */
@Aspect
@Component
public class LogAspect {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 定义切面，处理所有controller包下的所有类的方法
     */
    @Pointcut("execution(* com.smile.controller.*.*(..))")
    public void log() {}
    
    /**
     * 前置方法，方法执行前执行
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        
        //获取HttpServletRequest对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        //获取日志信息
        String url = request.getRequestURI().toString();
        String ip = request.getRemoteAddr();
        String className = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
    
        //生成result对象
        ResultLog resultLog = new ResultLog(url, ip, className, args);
        
        logger.info("Request {}",resultLog);
    }
    
    /**
     * 后置方法，方法执行后执行
     */
    @After("log()")
    public void doAfter() {
//        logger.info("----------doAfter---------");
    }
    
    /**
     * 返回方法，获取返回结果
     * @param result
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result) {
        logger.info("Result : {}" , result);
    }
    
    /**
     * 内部类用来接收日志信息
     * @param
     */
    private class ResultLog {
    
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    
        public ResultLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }
    
        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + args +
                    '}';
        }
    }
}
