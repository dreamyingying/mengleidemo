package com.menglei.family.account.common.utils;

import com.riversoft.weixin.common.message.MsgType;
import com.riversoft.weixin.common.message.xml.TextXmlMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @className MessageUtil
  * Description 微信消息类型的工具类
  * @date 2018/9/6 18:11
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class MessageUtil {

    /**
     * 文本消息
     */
    public static final String MESSAGE_TEXT = "text";

    /**
     * 图片消息
     */
    public static final String MESSAGE_IMAGE = "image";

    /**
     * 语音消息
     */
    public static final String MESSAGE_VOICE = "voice";

    /**
     * 视频消息
     */
    public static final String MESSAGE_VIDEO = "video";

    /**
     * 链接消息
     */
    public static final String MESSAGE_LINK = "link";

    /**
     * 地理位置
     */
    public static final String MESSAGE_LOCATION = "location";

    /**
     * 事件消息
     */
    public static final String MESSAGE_EVENT = "event";

    /**
     * 关注事件
     */
    public static final String EVENT_SUB = "subscribe";

    /**
     * 取消关注事件
     */
    public static final String EVENT_UNSUB = "unsubscribe";

    /**
     * 已关注的用户事件
     */
    public static final String EVENT_SCAN = "SCAN";

    /**
     * 上报地理位置事件
     */
    public static final String EVENT_LOCATION = "LOCATION";

    /**
     * 自定义菜单事件
     */
    public static final String EVENT_CLICK = "CLICK";

    /**
     * 点击菜单跳转链接的事件
     */
    public static final String EVENT_VIEW = "VIEW";









    /**
      * Description 将xml格式转换为map
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 11:47 2018/9/7
      * @param request 请求
      * @return Map
      **/
    public static Map<String,String> xml2Map(HttpServletRequest request)throws DocumentException, IOException {

        Map<String,String> map = new HashMap<>();

        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();
        List<Element> list = root.elements();
        for (Element element : list) {
            map.put(element.getName(),element.getText());
        }
        ins.close();
        return map;

    }


    /**
      * Description 编辑我的回复内容
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 10:36 2018/9/7
      * @return String
      **/
    public static String editMyContent(){
        return "欢迎关注孟磊的学习公众号！";
    }

    /**
      * Description 封装xml消息
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 10:41 2018/9/7
      * @param toUserName 开发者微信
      * @param fromUserName 发送者微信
      * @param content 开发者回复的内容
      * @return String
      **/
    public static String initText(String toUserName,String fromUserName,String content){

        StringBuffer sb = new StringBuffer("<xml>");

        sb
                //回复给谁
                .append("<ToUserName><![CDATA[").append(fromUserName).append("]]></ToUserName>")

                //是开发者回复
                .append("<FromUserName><![CDATA[").append(toUserName).append("]]></FromUserName>")

                //消息创建时间
                .append("<CreateTime>").append(new Date()).append("</CreateTime>")

                //消息类型为“文本”
                .append("<MsgType><![CDATA[text]]></MsgType>").append("<Content><![CDATA[")

                //回复的消息内容
                .append(content).append("]]></Content>")
                //.append("<FuncFlag>0<FuncFlag>")
                .append("</xml>");

        return sb.toString();
    }

    /**
      * Description 将TextXmlMessage对象转换为xml
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 10:50 2018/9/7
      * @param textXmlMessage TextXmlMessage对象
      * @return String
      **/
    public static String textMessageToXml(TextXmlMessage textXmlMessage){
        XStream xStream = new XStream();
        xStream.alias("xml",textXmlMessage.getClass());
        return xStream.toXML(textXmlMessage);
    }

}
