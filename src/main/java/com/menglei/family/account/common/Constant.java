package com.menglei.family.account.common;/**
  * @className Constant
  * Description 常量
  * @author Menglei（lei.meng@cmgplex.com)
  * @date 2018/9/11 11:38
  * @version 1.0
  **/
public interface Constant {

    /**
     * 点击类型的菜单按钮
     */
    String MENU_RESPONSE_TYPE_CLICK = "click";


    /**
     * 链接类型的菜单按钮(点击后跳转指定的url)
     */
    String MENU_RESPONSE_TYPE_VIEW = "view";


    /**
     * 点击后调用扫码，完成扫描二维码后显示扫描结果，
     * （如果是URL，则进入url）,且扫码结果会返回给开发者，开发者可以下发消息
     */
    String MENU_RESPONSE_TYPE_SCANCODE_PUSH= "scancode_push";


    /**
     * 扫码推事件且弹出“消息接收中”提示框用户点击按钮后，
     * 微信客户端将调起扫一扫工具，完成扫码操作后，
     * 将扫码的结果传给开发者，同时收起扫一扫工具，
     * 然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息
     */
    String MENU_RESPONSE_TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";


    /**
     * 弹出系统拍照发图用户点击按钮后，
     * 微信客户端将调起系统相机，完成拍照操作后，
     * 会将拍摄的相片发送给开发者，并推送事件给开发者，
     * 同时收起系统相机，随后可能会收到开发者下发的消息。
     */
    String MENU_RESPONSE_TYPE_PIC_SYSPHOTO = "pic_sysphoto";


    /**
     * 弹出拍照或者相册发图用户点击按钮后，
     * 微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。
     * 用户选择后即走其他两种流程。
     */
    String MENU_RESPONSE_TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";


    /**
     * 弹出微信相册发图器用户点击按钮后，
     * 微信客户端将调起微信相册，完成选择操作后，
     * 将选择的相片发送给开发者的服务器，并推送事件给开发者，
     * 同时收起相册，随后可能会收到开发者下发的消息。
     */
    String MENU_RESPONSE_TYPE_PIC_WEIXIN = "pic_weixin";


    /**
     * 弹出地理位置选择器用户点击按钮后，
     * 微信客户端将调起地理位置选择工具，
     * 完成选择操作后，将选择的地理位置发送给开发者的服务器，
     * 同时收起位置选择工具，随后可能会收到开发者下发的消息。
     */
    String MENU_RESPONSE_TYPE_LOCATION_SELECT = "location_select";


    /**
     * 下发消息（除文本消息）用户点击media_id类型按钮后，
     * 微信服务器会将开发者填写的永久素材id对应的素材下发给用户，
     * 永久素材类型可以是图片、音频、视频、图文消息。
     * 请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
     */
    String MENU_RESPONSE_TYPE_MEDIA_ID = "media_id";


    /**
     * 跳转图文消息URL用户点击view_limited类型按钮后，
     * 微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，
     * 永久素材类型只支持图文消息。
     * 请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
     */
    String MENU_RESPONSE_TYPE_VIEW_LIMITED = "view_limited";
}