package com.luopc.reflex.proxy.invacation;


public class RealSubject implements ISubject {

	@Override
	public void eat(String msg, int num) {
		
		System.out.println("wo yao chi "+ num+" 分量的 "+msg);

	}

}
