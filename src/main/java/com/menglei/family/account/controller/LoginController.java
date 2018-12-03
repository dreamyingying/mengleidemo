package com.menglei.family.account.controller;

import com.menglei.family.account.common.JsonResult;
import com.menglei.family.account.entity.User;
import com.menglei.family.account.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * @className LoginController
  * Description 登陆
  * @date 2018/8/21 11:59
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @Value("${curUserName}")
    private String userName;

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/admin/welcome")
    public String welcome(){
        return "/welcome";
    }

    /**
      * Description 验证登陆信息
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 15:01 2018/9/17
      **/
    @RequestMapping(value = "/admin/login")
    public String login(@RequestBody User user, HttpServletResponse response, HttpServletRequest request, ModelMap map){
        try {

            log.info("开始登陆，用户的登陆信息：{}",user);
            User user1 = this.userService.login(user.getUserName(), user.getPassword());
            if (null != user1) {
                log.info("登陆信息验证通过：user={}",user);
                request.getSession().setAttribute(this.userName,user.getUserName());

                response.sendRedirect("/admin/index");
                return "redirect:/admin/index";
            }
                log.warn("账号或密码错误，登陆失败。user={}",user);
            map.put("errorMsg","账号或密码错误");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "/login";
    }
}
