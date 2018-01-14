package com.design.prototype;

import java.io.IOException;

public class PrototypeDemo {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		
		String name = "zhangsan";
		int age = 22;
		StringBuilder address = new StringBuilder("广西桂林恭城");
		Prototype p1 =  new Prototype(name, age, address);
		
		Prototype p2 = (Prototype) p1.clone();
		Prototype dp2 =  (Prototype) p1.deepClone();
		System.out.println("p2:" + p2);
		System.out.println("dp2:" + dp2);
		
		p1.address = new StringBuilder("广东佛山顺德");
		System.out.println("p2:" + p2);
		System.out.println("dp2:" + dp2);
		
		p1.setAddress(address);
		Prototype p3 = (Prototype) p1.clone();
		Prototype dp3 =  (Prototype) p1.deepClone();
		System.out.println("p2:" + p2);
		System.out.println("dp2:" + dp2);
		System.out.println("p3:" + p3);
		System.out.println("dp3:" + dp3);
		

	}

}
