package com.menglei.family.account.entity.wechatbutton;

import java.util.List;

/**
  * @className Button
  * Description 微信自定义菜单按钮
  * @date 2018/9/11 11:20
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class Button extends BaseButton{

    private List<SubButton> sub_button;

    public List<SubButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<SubButton> sub_button) {
        this.sub_button = sub_button;
    }

    @Override
    public String toString() {
        return "Button{" +
                "sub_button=" + sub_button +
                "} " + super.toString();
    }
}
