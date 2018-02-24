package com.luopc.reflex.demo;

/**
 * 静态代理实现
 * 
 * @author luopc
 *
 */
public class SimpleProxy implements IService {
    
    private IService service;// 被代理人

    public SimpleProxy(IService service) {
        this.service = service;
    }

    @Override
    public void send() {
        System.out.println("send-----start");
        service.send();
        System.out.println("send-----end");
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething-----start");
        service.doSomething();
        System.out.println("doSomething-----end");

    }
}
