package com.lambert.fun.exception;


import com.lambert.fun.result.ResultEnum;

/**
 * @Description: 业务异常
 * @Author: liyupeng
 * @Date: 2020/6/19
 */
public class BusinessException extends RuntimeException{

    // 错误码
    private int code;
    // 错误信息
    private String msg;

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(ResultEnum resultEnum, Object...s){
        this.msg = resultEnum.getMsg();
        this.code = resultEnum.getCode();
        if(s.length > 0){
            this.msg = String.format(resultEnum.getMsg(), s);
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

