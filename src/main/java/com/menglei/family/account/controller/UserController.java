package com.menglei.family.account.controller;

import com.menglei.family.account.common.JsonResult;
import com.menglei.family.account.entity.User;
import com.menglei.family.account.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
  * @className UserController
  * Description 成员的controller
  * @date 2018/8/17 13:53
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Value("${curUserName}")
    private String userName;

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public JsonResult<Integer> insert(@RequestBody User user, HttpServletRequest request){
        JsonResult<Integer> jr = new JsonResult<>();
        //String curUserName = (String)request.getSession().getAttribute(this.userName);
        String curUserName = "menglei";
        try {
            int i = this.userService.insert(user,curUserName);
            jr.setData(i);
            if (i == 1){
                jr.setCode("8200");
                jr.setMessage("添加成功");
            }else {
                jr.setCode("8201");
                jr.setMessage("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jr;
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JsonResult<List<User>> list(){
        JsonResult<List<User>> jr = new JsonResult<>();
        try {
            List<User> userList = this.userService.getAll();
            if (null == userList || userList.size() == 0){
                jr.setMessage("未找到符合条件的数据");
                jr.setCode("8202");
            }else {
                jr.setMessage("获取数据成功");
                jr.setCode("8200");
            }
            jr.setData(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jr;
    }
}
