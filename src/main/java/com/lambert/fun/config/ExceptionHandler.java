package com.lambert.fun.config;

import com.lambert.fun.exception.BusinessException;
import com.lambert.fun.result.Result;
import com.lambert.fun.result.ResultEnum;
import com.lambert.fun.result.ResultHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * @Description: 异常捕获
 * @Author: liyupeng
 * @Date: 2020/6/19
 */
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
    public Result noElementHandle(NoSuchElementException e){
        return ResultHandler.result(ResultEnum.NO_DATA);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Result validHandle(MethodArgumentNotValidException e){
        return ResultHandler.validateErrors(e.getBindingResult());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public Result businessHandle(BusinessException e){
        return ResultHandler.result(e.getCode(), e.getMsg(), null);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result defaultHandle(Exception e){
        e.printStackTrace();
        return ResultHandler.result(ResultEnum.UNKNOWN_EXCEPTION);
    }

}
