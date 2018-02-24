package com.luopc.reflex.demo;

import java.lang.reflect.Proxy;

public class IServiceDemo {

    public static void main(String[] args) {
        ServiceImpl simpl = new ServiceImpl();
        simpl.send();
        simpl.doSomething();
        
        System.out.println("-------------------简单静态代理实现---------------------");
        IService simple_proxy = new SimpleProxy(simpl);
        simple_proxy.send();
        simple_proxy.doSomething();
        
        System.out.println("-------------------jdk动态代理实现-01---------------------");
        IService is = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[] { IService.class },
                new ServiceProxyHandle(simpl));
        is.send();
        is.doSomething();
        
        System.out.println("--------------------jdk动态代理实现-02--------------------");
        ServiceProxyHandle jdkproxy = new ServiceProxyHandle();
        IService is2 = (IService) jdkproxy.bind(simpl);
        is2.send();
        is2.doSomething();
        
        System.out.println("--------------------cglib动态代理实现--------------------");
        ServiceCglibProxyInterceptor cglibProxy = new ServiceCglibProxyInterceptor();
        IService is3 = (IService) cglibProxy.bind(simpl);
        is3.send();
        is3.doSomething();
    }

}
