package com.smile.interceptor.WebConfigurer;

import com.smile.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截规则添加
 * @Author: smile
 * @Date: 2020/1/20
 */
@Configuration
public class LoginConfigurerAdapter implements WebMvcConfigurer {
    
    /**
     * 拦截器规则添加，可以添加多个拦截器,配置拦截路径，排除路劲
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");

    }
    
    /**
     * 静态页面跳转配置，访问：http://localhost:8080/admin，跳转到admin/下的login.html页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin/login");
        registry.addViewController("/about").setViewName("about");
    }
}
