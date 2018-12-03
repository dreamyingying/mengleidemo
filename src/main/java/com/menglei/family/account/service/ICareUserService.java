package com.menglei.family.account.service;

import com.menglei.family.account.entity.CareUser;

/**
  * @className ICareUserService
  * Description 关注公众号的用户的业务层
  * @author Menglei（lei.meng@cmgplex.com)
  * @date 2018/8/30 11:18
  * @version 1.0
  **/
public interface ICareUserService {

    /**
      * Description 新增关注的用户
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 11:19 2018/8/30
      * @param careUser 关注的用户的实体
      * @return int
      **/
    int insert(CareUser careUser);


    /**
      * Description 通过id获取关注用户
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 17:26 2018/9/10
      * @param id 主键
      * @return CareUser
      **/
    CareUser findById(Long id);


    /**
      * Description 将此关注用户的状态更新为已关注
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 17:27 2018/9/10
      * @param careUser 关注用户
      * @return int
      **/
    int changeStatusActive(CareUser careUser);


    /**
     * Description 将此关注用户的状态更新为未关注
     * @author Menglei（lei.meng@cmgplex.com)
     * @date 17:27 2018/9/10
     * @param careUser 关注用户
     * @return int
     **/
    int changeStatusUnActive(CareUser careUser);


    /**
      * Description 更新关注用户
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 17:31 2018/9/10
      * @param careUser
      * @return int
      **/
    int update(CareUser careUser);


    /**
      * Description 通过openId获取关注用户
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 17:37 2018/9/10
      * @param openId 用户的openId
      * @return  CareUser
      **/
    CareUser findByOpenId(String openId);
}