package com.menglei.family.account.common;/**
  * @className JsonResult
  * Description 统一返回json格式
  * @date 2018/8/16 18:29
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public class JsonResult<T> {
    private String code;
    private String message;
    private T data;

    public JsonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult() {
    }

    public JsonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
