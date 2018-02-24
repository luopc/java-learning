package com.luopc.reflex.demo;

public class ServiceImpl implements IService {

    @Override
    public void send() {
       System.out.println("I am Send Method~");

    }

    @Override
    public void doSomething() {
        System.out.println("I am doSomething Method~");
    }

}
