package com.lambert.fun.result;

public class ValidateError {

    private String param;

    private String tip;

    public ValidateError(String param, String tip) {
        this.param = param;
        this.tip = tip;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}

