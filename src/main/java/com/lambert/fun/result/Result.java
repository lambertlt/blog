package com.lambert.fun.result;

public class Result<T> {

    private int code;
    private String msg;
    private T res;

    public Result() {
    }

    public Result(int code, String msg, T res) {
        this.code = code;
        this.msg = msg;
        this.res = res;
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

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }
}
