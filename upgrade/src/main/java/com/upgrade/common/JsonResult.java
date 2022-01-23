package com.upgrade.common;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:23
 */
public class JsonResult<T> {

    private int code;
    private T data;
    private String message;

    public JsonResult(int code, T data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public JsonResult(){
        this.code = 200;
        this.data = null;
        this.message = "success";
    }

    public JsonResult<T> success(T data, String message){
        this.code = 200;
        this.data = data;
        this.message = message;
        return new JsonResult<T>(code, data, message);
    }

    public JsonResult<T> fail(T data, String message){
        this.code = 500;
        this.data = data;
        this.message = message;
        return new JsonResult<T>(code, data, message);
    }

    public JsonResult<T> success(T data){
        this.code = 200;
        this.data = data;
        this.message = "success";
        return new JsonResult<T>(code, data, message);
    }

    public JsonResult<T> fail(T data){
        this.code = 500;
        this.data = data;
        this.message = "fail";
        return new JsonResult<T>(code, data, message);
    }

    public static<T> JsonResult<T> success(){
        return new JsonResult<T>(200, null, "success");
    }

    public static<T> JsonResult<T> fail(){
        return new JsonResult<T>(500, null, "fail");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
