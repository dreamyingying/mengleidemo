package com.menglei.family.account.config.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * @className LoginInterceptor
  * Description 登陆拦截器
  * @date 2018/9/17 14:11
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userName = (String)request.getSession().getAttribute("userName");
        if (null == userName){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
