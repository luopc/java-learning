package com.spring.java.proxy;

public class ServiceImpl implements IService {

    @Override
    public void send() {
        System.out.println("send");
    }

}
