package com.spring.java.proxy;

public class ServiceDemo {

    public static void main(String[] args) {
        ServiceImpl simpl = new ServiceImpl();
        ServiceInvocationProxy proxy = new ServiceInvocationProxy();
        IService is = (IService) proxy.build(simpl);
        is.send();
        
        ServiceCglibProxy cproxy = new ServiceCglibProxy();
        IService is2 = (IService) cproxy.bind(simpl);
        is2.send();
    }

}
