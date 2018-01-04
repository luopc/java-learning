package com.luopc.reflex.proxy;

public class ProxyDemo {

	public static void main(String[] args) {
		ISubject subject = Factory.getInstance("com.luopc.reflex.proxy.ProxySubject", Factory.getInstance("com.luopc.reflex.proxy.RealSubject"));
		subject.eat();
	}

}

