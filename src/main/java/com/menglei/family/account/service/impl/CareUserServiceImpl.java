package com.menglei.family.account.service.impl;

import com.menglei.family.account.dao.ICareUserDAO;
import com.menglei.family.account.entity.CareUser;
import com.menglei.family.account.service.ICareUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  * @className CareUserServiceImpl
  * Description 关注的用户的业务实现层
  * @date 2018/8/30 11:20
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
@Service("careUserService")
public class CareUserServiceImpl implements ICareUserService {

    @Autowired
    private ICareUserDAO careUserDAO;

    @Override
    public int insert(CareUser careUser) {
        careUser.setStatus((byte)1);
        careUser.setCreater("menglei");
        careUser.setCreateTime(System.currentTimeMillis());
        careUser.setUpdater("menglei");
        careUser.setUpdateTime(careUser.getCreateTime());
        careUser.setDescription("-");
        return this.careUserDAO.insert(careUser);
    }

    @Override
    public int update(CareUser careUser) {
        careUser.setUpdateTime(System.currentTimeMillis());
        careUser.setUpdater("menglei");
        return this.careUserDAO.update(careUser);
    }

    @Override
    public CareUser findById(Long id) {
        return this.careUserDAO.findById(id);
    }

    @Override
    public int changeStatusActive(CareUser careUser) {
        careUser.setStatus((byte)1);
        return this.update(careUser);
    }

    @Override
    public int changeStatusUnActive(CareUser careUser) {
        careUser.setStatus((byte)99);
        return this.update(careUser);
    }

    @Override
    public CareUser findByOpenId(String openId) {
        return this.careUserDAO.findByProperty("open_id",openId);
    }
}
