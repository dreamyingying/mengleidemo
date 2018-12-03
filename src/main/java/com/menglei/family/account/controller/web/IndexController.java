package com.menglei.family.account.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * @className IndexController
  * Description 默认页面
  * @date 2018/8/20 14:55
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
      * Description 系统首页
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 14:57 2018/8/20
      * @return String
      **/
    @RequestMapping(value = {"/","/index"})
    public String index(){
        logger.info("进入首页");
        return "index";
    }
}
