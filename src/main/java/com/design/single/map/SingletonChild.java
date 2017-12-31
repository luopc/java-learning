package com.design.single.map;

public class SingletonChild extends Singleton {
	
	public SingletonChild() {
		
	}
	
	static public SingletonChild getInstance() {
		return  (SingletonChild) Singleton.getInstance("com.design.single.map.SingletonChild");
	}

	public void showly() {
		System.out.println("Instance SingletonChild Success~");
	}
}
