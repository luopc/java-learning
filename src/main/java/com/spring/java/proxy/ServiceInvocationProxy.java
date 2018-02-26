package com.spring.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceInvocationProxy implements InvocationHandler {

    private Object proxied;

    public Object build(Object obj) {
        this.proxied = obj;
        Object rs = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
        return rs;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(proxied, args);
        return null;
    }

}
