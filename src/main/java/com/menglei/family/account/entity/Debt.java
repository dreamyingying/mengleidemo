package com.menglei.family.account.entity;/**
  * @className Debt
  * Description 债务实体
  * @date 2018/8/16 18:22
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class Debt extends BaseEntity{
    /**
     * 债务名称
     */
    private String name;

    /**
     * 债务类型
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
     * 当前债务汇总
     */
    private  double summary;

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

    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Debt{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", quota=" + quota +
                ", updateExplain='" + updateExplain + '\'' +
                ", summary=" + summary +
                "} " + super.toString();
    }
}
