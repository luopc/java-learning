package com.luopc.reflex.proxy;

public class RealSubject implements ISubject {

	@Override
	public void eat() {
		System.out.println("饿了就要吃~");

	}

}
