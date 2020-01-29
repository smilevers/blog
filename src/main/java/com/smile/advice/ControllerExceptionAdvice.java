package com.smile.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 * 拦截所有controller方法的异常，不区分状态码，统一跳转到erro
 * @Author: smile
 * @Date: 2020/1/20
 */
@ControllerAdvice
public class ControllerExceptionAdvice {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 将异常返回到erro页面,并打印错误日志，且页面源码可以查看错误信息
     * @param request
     * @param e
     * @return mv
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionInterceptor(HttpServletRequest request,Exception e) throws Exception {

        logger.error("Requse  URL : {},Exception : {}",request.getRequestURL(),e.getMessage());
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null) {
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURI());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
    
}
