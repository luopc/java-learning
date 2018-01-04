package com.design.single.map;

import java.util.HashMap;

public class Singleton {
	
	private static HashMap<String,Singleton> sinRegistry = new HashMap<>();

	static private Singleton  s = new Singleton();
	
	protected Singleton() {
		
	}
	
	public static Singleton getInstance(String name) {
		if(name == null) {
			name = "com.design.single.map.Singleton";
		}else if(sinRegistry.get(name) == null) {
			try {
				sinRegistry.put(name, (Singleton) Class.forName(name).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return sinRegistry.get(name);
	}
	
	public void showly() {
		System.out.println("Instance Single Success~");
	}
}
