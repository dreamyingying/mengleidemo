package com.menglei.family.account.entity.wechatbutton;/**
  * @className BaseButton
  * Description 微信自定义菜单按钮的基础类
  * @date 2018/9/11 12:07
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class BaseButton {

    /**
     * 菜单名称（不超过4个中文汉字,即16个字节）
     */
    private String name;


    /**
     * 菜单按钮的响应类型
     */
    private String type;

    /**
     * 当type为click时，需要设值
     */
    private String key;

    /**
     * 当type为view\miniprogram时，需要设值
     */
    private String url;

    /**
     * 当type为media_id类型和view_limited类型必须设值，调用新增永久素材接口返回的合法media_id
     */
    private String media_id;

    /**
     * 当type为miniprogram类型必须设值，小程序的appid（仅认证公众号可配置）
     */
    private String appid;

    /**
     * 当type为miniprogram类型必须设值，小程序的页面路径
     */
    private String pagepath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    @Override
    public String toString() {
        return "BaseButton{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", media_id='" + media_id + '\'' +
                ", appid='" + appid + '\'' +
                ", pagepath='" + pagepath + '\'' +
                '}';
    }
}
