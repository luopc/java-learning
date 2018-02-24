package com.luopc.reflex.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		Message msg = new Message();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Class.forName("com.luopc.reflex.proxy.cglib.Message"));
		enhancer.setCallback(new MessageProxy(msg));
		
		Message temp = (Message) enhancer.create();
		temp.send();

	}

}
