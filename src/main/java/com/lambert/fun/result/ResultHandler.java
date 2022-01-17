package com.lambert.fun.result;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultHandler {

    public static Result validateErrors(BindingResult bindingResult){
        List<ValidateError> errors = bindingResult.getFieldErrors()
                .stream()
                .map(item -> new ValidateError(item.getField(), item.getDefaultMessage()))
                .collect(Collectors.toList());
        return result(ResultEnum.PARAM_ERROR, errors);
    }

    public static Result result() {
        return new Result(ResultEnum.RESULT.getCode(), ResultEnum.RESULT.getMsg(), null);
    }

    public static Result result(Object res) {
        return new Result(ResultEnum.RESULT.getCode(), ResultEnum.RESULT.getMsg(), res);
    }

    public static Result result(ResultEnum resultEnum) {
        return new Result(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static Result result(int code, String msg, Object res) {
        return new Result(code, msg, res);
    }

    public static Result result(ResultEnum resultEnum, Object res) {
        return new Result(resultEnum.getCode(), resultEnum.getMsg(), res);
    }
}
