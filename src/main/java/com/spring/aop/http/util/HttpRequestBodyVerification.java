package com.spring.aop.http.util;

import com.spring.aop.http.bo.BasicHttpRequestBo;
import jodd.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpRequestBodyVerification {

    public void verifyHeader(JoinPoint point){
        System.out.println("---------------- Verify Header -----------------");
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        String [] paramNames = methodSignature.getParameterNames();
        Object [] args = point.getArgs();

        RequestParam requestParam = getRequestParam(args, paramNames);
        printLog(requestParam);
    }


    public Object verifyBody(ProceedingJoinPoint point, VerifyBody verifyBody){
        System.out.println("---------------- Verify Body -----------------");

        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        String [] paramNames = methodSignature.getParameterNames();
        Object [] args = point.getArgs();

        RequestParam requestParam = getRequestParam(args, paramNames);
        printLog(requestParam);


        // 注解中的类型
        VerifyBodyPolicy verifyPolicy = verifyBody.type();
        System.out.println(verifyPolicy.name());

        try {

            if(verifyByPolicy(verifyPolicy, requestParam)){
                return point.proceed();
            }else {
                System.err.println("Verify request failed.");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "Error";
    }

    public boolean verifyByPolicy( VerifyBodyPolicy verifyPolicy, RequestParam requestParam){
        BasicHttpRequestBo requestBody = requestParam.getRequestBo();
        if(VerifyBodyPolicy.MUST_BE_CONSISTENT == verifyPolicy){
            if(requestBody != null && StringUtil.equals(requestParam.getId(), requestBody.getId())){
                return true;
            }
        }else if(VerifyBodyPolicy.SHOULD_BE_NULL  == verifyPolicy &&
                (StringUtil.isBlank(requestParam.getId()) && ( requestBody == null || StringUtil.isBlank(requestBody.getId()))) ){
                return true;
        }
        return false;
    }

    private void printLog(RequestParam requestParam) {
        System.out.println("Receive param , ID = " + requestParam.getId());
        System.out.println("Receive param , Name = " + requestParam.getName());
        System.out.println("Receive param from Body, ID = " + (requestParam.getRequestBo() == null ? "null" : requestParam.getRequestBo().getId()));
    }

    private RequestParam getRequestParam(Object [] args, String [] paramNames) {
        RequestParam requestParam = new RequestParam();
        if(args != null){
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                String paramName = paramNames[i];
                if(arg instanceof String && this.isExist(requestParam, paramName)) {
                    String value = String.valueOf(arg);
                    this.setParam(requestParam, paramName, value);
                }else if(arg instanceof BasicHttpRequestBo && this.isExist(requestParam, paramName)){
                    BasicHttpRequestBo obj = (BasicHttpRequestBo) arg;
                    requestParam.setRequestBo(obj);
                }
            }
        }
        return requestParam;
    }

    private <T> void setParam(T targetClass, String key, String value) {
        try {
            Method targetClassParamSetMethod = targetClass.getClass().getMethod("set" + this.setFirstLetterUpperCase(key), String.class);
            targetClassParamSetMethod.invoke(targetClass, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    private <T> Boolean isExist(RequestParam requestParam, String name) {
        boolean exist = true;
        try {
            String key = this.setFirstLetterUpperCase(name);
            requestParam.getClass().getMethod("get" + key);
        } catch (Exception e) {
            exist = false;
        }
        return exist;
    }

    private String setFirstLetterUpperCase(String str) {
        if (str != null) {
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return str;

    }

}
