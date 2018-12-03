package com.menglei.family.account.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
  * @className BaseEntity
  * Description 基础实体
  * @date 2018/8/16 11:36
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建人和创建时间
     */
    private Long createTime;
    private String creater;

    /**
     * 修改人和修改时间
     */
    private Long updateTime;
    private String updater;

    /**
     * 描述
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 格式化创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    public Date getCreateTimeFormat(){
        if (this.createTime == null){
            return new Date();
        }
        return this.createTime > 0 ? new Date(this.createTime) : null ;
    }

    /**
     * 格式化修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    public Date getUpdateTimeFormat(){
        if (this.updateTime == null){
            return new Date();
        }
        return this.updateTime > 0 ? new Date(this.updateTime) : null ;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                "createTime=" + createTime +
                ", creater='" + creater + '\'' +
                ", updateTime=" + updateTime +
                ", updater='" + updater + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
