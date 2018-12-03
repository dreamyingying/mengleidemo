package com.menglei.family.account.service.impl;

import com.menglei.family.account.dao.IUserDAO;
import com.menglei.family.account.entity.User;
import com.menglei.family.account.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @className UserServiceImpl
  * Description 成员对象的逻辑处理
  * @date 2018/8/17 13:49
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public int insert(User user,String curUserName) {
        user.setCreater(curUserName);
        user.setUpdater(curUserName);
        user.setCreateTime(System.currentTimeMillis());
        user.setUpdateTime(user.getCreateTime());
        return this.userDAO.insert(user);
    }

    @Override
    public int update(User user,String curUserName) {
        user.setUpdateTime(System.currentTimeMillis());
        user.setUpdater(curUserName);
        return this.userDAO.update(user);
    }

    @Override
    public int deleteById(Long id) {
        return this.userDAO.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        return this.userDAO.findById(id);
    }

    @Override
    public List<User> getAll() {
        return this.userDAO.findAll(null);
    }

    @Override
    public User login(String userName, String password) {
        Map<String,Object> condition = new HashMap<>(2);
        condition.put("userName",userName);
        condition.put("password",password);
        condition.put("status",1);
        return this.userDAO.queryOne(condition);
    }
}
