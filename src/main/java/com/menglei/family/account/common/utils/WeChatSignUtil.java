package com.menglei.family.account.common.utils;

import org.springframework.beans.factory.annotation.Value;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
  * @className WeChatSignUtil
  * Description 验证请求是否来自微信的工具类
  * @date 2018/9/6 17:01
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class WeChatSignUtil {

    /**
     * 验证微信加密签名：
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     */
    public static boolean checkSignature(String token, String signature,String timestamp,String nonce){

        //1.将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);

        //2.将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        MessageDigest md = null;
        String tmpstr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(sb.toString().getBytes());
            tmpstr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return tmpstr != null && tmpstr.equals(signature.toUpperCase());
    }

    /**
     * byte数组转换为十六进制字符串
     */
    public static String byteToStr(byte[] byteArray){
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            sb.append(byteToHexStr(b));
        }
        return sb.toString();
    }

    /**
     * 将字节转换为十六进制字符串
     */
    public static String byteToHexStr(byte b){

        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = digit[(b >>> 4) & 0X0F];
        tempArr[1] = digit[b & 0X0F];
        return new String(tempArr);
    }
}
