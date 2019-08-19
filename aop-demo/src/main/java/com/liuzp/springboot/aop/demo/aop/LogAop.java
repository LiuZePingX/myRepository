package com.liuzp.springboot.aop.demo.aop;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.liuzp.springboot.aop.demo.annotation.AdminTest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ClassName:
 * @Description: 切面
 * @author: liuzp
 * @date:   2019/8/19 14:51
 *
 */
@Aspect
@Component
@Slf4j
public class LogAop {

    /**
     * 切点:
     * 使用注解方式注入切点
     * 只有拥有相应注解的方法才会去拦截
     */
    @Pointcut("@annotation(com.liuzp.springboot.aop.demo.annotation.AdminTest)") // 使用注解对代码具有一定侵入性
    public void adminTest() {

    }

    @Before("adminTest()")
    public void checkLog(JoinPoint point) {
        Object[] o = point.getArgs();
        String s = JSONObject.toJSONString(o);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Enumeration<String> s1 = request.getHeaderNames();
        log.info("拦截方法");
    }

    // @Around("adminTest()")
    public Object getParam(ProceedingJoinPoint proceedingJoinPoint) {

        Object[] o = null;
        try {
            log.info("环绕aop");
            o = proceedingJoinPoint.getArgs();
            System.out.println(o.toString());
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }
}
