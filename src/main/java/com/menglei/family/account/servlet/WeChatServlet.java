package com.menglei.family.account.servlet;

import com.menglei.family.account.common.utils.MessageUtil;
import com.menglei.family.account.common.utils.WeChatSignUtil;
import com.menglei.family.account.entity.CareUser;
import com.menglei.family.account.service.ICareUserService;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
  * @className WeChatServlet
  * Description 处理微信请求
  * @date 2018/9/7 11:15
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
@WebServlet(name = "weChatServlet", urlPatterns = "/weChatServlet")
public class WeChatServlet extends HttpServlet {

    private static final long serialVersionUID = -2825093001137664452L;

    private static final Logger log = LoggerFactory.getLogger(WeChatServlet.class);

    @Value("${weChat.token}")
    private String token;

    @Autowired
    private ICareUserService careUserService;

    /**
      * Description 确认请求来之微信服务器
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 11:18 2018/9/7
      * @param request 请求
      * @param response 响应
      **/
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {

        //微信加密签名
        String signature = request.getParameter("signature");

        //时间戳
        String timestamp = request.getParameter("timestamp");

        //随机数
        String nonce = request.getParameter("nonce");

        //随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();

        /**
         * 通过校验signature，如果校验成功原样返回echostr,表示接入成功，否则接入失败
         */
        if (WeChatSignUtil.checkSignature(this.token,signature,timestamp,nonce)){
            log.info("echostr = {}",echostr);
            out.write(echostr);
        }
        out.close();
        out = null;
    }


    /**
      * Description 处理微信服务器发来的消息
      * @author Menglei（lei.meng@cmgplex.com)
      * @date 11:29 2018/9/7
      * @param request 请求
      * @param response 响应
      **/
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException{

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String message = "";

        try {
            //将微信的请求数据转换为map
            Map<String, String> map = MessageUtil.xml2Map(request);
            log.info("接收到的微信请求的map数据为：{}",map);

            //开发者微信号
            String toUserName = map.get("ToUserName");

            //发送者微信号
            String openId = map.get("FromUserName");

            //消息类型
            String msgType = map.get("MsgType");
            log.info("本次消息的消息类型为：{}",msgType);

            //请求内容
            String content = map.get("Content");



 //--------------------------------判断请求是否是事件Event----------------【Event--start】-------------------------------------------事件类型消息的处理--------------------------

            if (MessageUtil.MESSAGE_EVENT.equals(msgType)){
                String eventType = map.get("Event");
                log.info("此消息为事件消息，事件的类型为：{}",eventType);


                //判断是已关注的扫描事件
                if (MessageUtil.EVENT_SCAN.equals(eventType)){
                    return;
                }


                //判断用户是取消关注
                if (MessageUtil.EVENT_UNSUB.equals(eventType)){
                    CareUser careUser = careUserService.findByOpenId(openId);
                    this.careUserService.changeStatusUnActive(careUser);
                    return;
                }

                //到此可以判定为关注事件


                //先查询数据库中是否存在此用户（之前是否关注过，后来取消的）
                CareUser careUser = this.careUserService.findByOpenId(openId);
                if (null != careUser){
                    //进来说明之前关注过，只需要更改状态为已关注就行
                    this.careUserService.changeStatusActive(careUser);
                }else {
                    //到这里说明是新用户，新增
                    CareUser careUser1 = new CareUser();
                    careUser1.setOpenId(openId);
                    int i = this.careUserService.insert(careUser1);
                    if (1==i){
                        log.info("新增成功，新增用户的openId：{}",openId);
                    }else {
                        log.error("关注用户新增失败，用户的openId为：{}",openId);
                    }
                }

                //给微信服务器返回
                    String myContent = MessageUtil.editMyContent();
                    message = MessageUtil.initText(toUserName, openId, myContent);
                    log.info("此事件为关注事件，返回给微信的完整数据为：{}",message);

            }
//--------------------------------事件消息处理结束---------------------------【Event---End】--------------------------------事件类型消息的处理---------------------------------------


            out.write(message);
            log.info("已给微信响应，响应的数据为：{}",message);
        } catch (DocumentException e) {
            e.printStackTrace();
            log.error("未知异常，异常描述为：{}",e.getMessage());
            out.close();
        }
    }
}
