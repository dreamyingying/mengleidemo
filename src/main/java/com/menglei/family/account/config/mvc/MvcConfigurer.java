package com.menglei.family.account.config.mvc;

import com.menglei.family.account.config.intercepter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
  * @className MvcConfigurer
  * Description mvc配置
  * @date 2018/9/17 14:07
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    /**
     * 拦截器（拦截用户是否登陆）
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/");
    }

}
