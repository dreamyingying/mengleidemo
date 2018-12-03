package com.menglei.family.account.entity;/**
  * @className CareUser
  * Description 关注公众号的用户实体
  * @date 2018/8/30 11:02
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class CareUser extends BaseEntity {

    /**
     * 用户的openId
     */
    private String openId;

    /**
     * 关注的状态【1：已关注；99：已取关】
     */
    private byte status;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CareUser{" +
                "openId='" + openId + '\'' +
                ", status=" + status +
                "} " + super.toString();
    }
}
