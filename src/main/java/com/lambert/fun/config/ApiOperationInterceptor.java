package com.lambert.fun.config;

import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Component;
import com.lambert.fun.utils.JSONUtil;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Description: swagger注解拦截并添加log
 * @Author: liyupeng
 * @Date: 2020/6/19
 */
@Aspect
@Component
public class ApiOperationInterceptor {

    //在注解的位置切入代码
    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void logPointCut() {
    }

    //切面 先执行
    @Before("logPointCut()")
    public void log(JoinPoint joinPoint) {

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);

        //请求的参数
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        HashMap map = new HashMap();

        //封装参数体
        for (int i = 0; i < args.length; i++) {
            if (!(args[i] instanceof InputStreamSource || args[i] instanceof HttpServletResponse
                    || args[i] instanceof HttpServletResponse)) {
                map.put(parameterNames[i], args[i]);
            }
        }

        String className = joinPoint.getTarget().getClass().getName();

        if (map.size() > 0) {
            LoggerFactory.getLogger(className).info(apiOperation.value() + "：" + JSONUtil.toJSONString(map));
        } else {
            LoggerFactory.getLogger(className).info(apiOperation.value());
        }
    }
}
