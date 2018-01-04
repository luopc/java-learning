package com.luopc.reflex.proxy.invacation;

public class InvocationProxyDemo {
	public static void main(String[] args) {
		ISubject subject = (ISubject) new ProxySubject().bind(new RealSubject());;
		subject.eat("dami", 5);
	}

}
