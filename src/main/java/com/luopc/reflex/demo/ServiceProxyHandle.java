package com.luopc.reflex.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过JDK动态代理实现
 * @author luopc
 *
 */
public class ServiceProxyHandle implements InvocationHandler {
    
    private Object proxied;
    
    public ServiceProxyHandle(Object proxied) {
        this.proxied = proxied;
    }
    
    public ServiceProxyHandle() {
    }

    public Object bind(Object proxied) {
        this.proxied = proxied;
        return Proxy.newProxyInstance(proxied.getClass().getClassLoader(),
                proxied.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("do")) {
            System.out.println("开始执行do方法~");
        }
        Object ret = method.invoke(proxied, args);
        return ret;
    }

}
