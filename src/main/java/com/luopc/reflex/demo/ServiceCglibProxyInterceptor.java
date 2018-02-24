package com.luopc.reflex.demo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ServiceCglibProxyInterceptor implements MethodInterceptor {
    
    private Object proxied;
    
    public Object bind(Object proxied) {
        this.proxied = proxied;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(proxied.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(method.getName().startsWith("do")) {
            System.out.println("开始执行do方法~");
        }
        Object ret = method.invoke(proxied, args);
        return ret;
    }

}
