package com.menglei.family.account.service;

import com.menglei.family.account.entity.User;

import java.util.List;

/**
  * @className IUserService
  * Description 成员service接口
  * @author Menglei（lei.meng@cmgplex.com)
  * @date 2018/8/17 13:41
  * @version 1.0
  **/
public interface IUserService {

    /**
      * Description 新增一名成员
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 13:44 2018/8/17
      * @param user 成员对象
      * @param curUserName 当前操作成员
      * @return 新增条数
      **/
    int insert(User user,String curUserName);

    /**
      * Description 更新成员数据
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 13:45 2018/8/17
      * @param user 成员对象
      * @param curUserName 当前操作成员
      * @return 更新成功的条数
      **/
    int update(User user,String curUserName);

    /**
      * Description 通过主键删除一名成员
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 13:46 2018/8/17
      * @param id 主键
      * @return 删除成功的条数
      **/
    int deleteById(Long id);

    /**
      * Description 通过主键查询一名成员
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 13:47 2018/8/17
      * @param id 主键
      * @return 成员对象
      **/
    User getById(Long id);

    /**
      * Description 获取所有的成员
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 13:48 2018/8/17
      * @return 所有成员的集合
      **/
    List<User> getAll();


    /**
      * Description 通过用户名和密码登陆
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 14:40 2018/9/17
      * @param userName 用户名
      * @param password 密码
      * @return user
      **/
    User login(String userName,String password);
}