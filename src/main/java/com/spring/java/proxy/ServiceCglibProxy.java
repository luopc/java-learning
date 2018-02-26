package com.spring.java.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ServiceCglibProxy implements MethodInterceptor {

    private Object proxied;

    public Object bind(Object obj) {
        this.proxied = obj;
        Enhancer eh = new Enhancer();
        eh.setSuperclass(obj.getClass());
        eh.setCallback(this);
        return eh.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        method.invoke(proxied, args);
        return null;
    }

}
