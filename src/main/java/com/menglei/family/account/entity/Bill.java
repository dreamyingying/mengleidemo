package com.menglei.family.account.entity;/**
  * @className Bill
  * Description 账单实体
  * @date 2018/8/16 12:08
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class Bill extends BaseEntity{
    /**
     * 账单名
     */
    private String name;

    /**
     * 账单类型【1.消费；2.存入；3.还债；4.收账；5.外借；6.借入】
     */
    private byte type;

    /**
     * 额度
     */
    private double quota;

    /**
     * 修改原因
     */
    private String updateExplain;

    /**
     * 余额
     */
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public String getUpdateExplain() {
        return updateExplain;
    }

    public void setUpdateExplain(String updateExplain) {
        this.updateExplain = updateExplain;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", quota=" + quota +
                ", updateExplain='" + updateExplain + '\'' +
                ", balance=" + balance +
                "} " + super.toString();
    }
}
