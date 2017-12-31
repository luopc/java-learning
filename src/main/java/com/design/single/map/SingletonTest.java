package com.design.single.map;

public class SingletonTest {

	public static void main(String[] args) {

		Singleton s1 = Singleton.getInstance("com.design.single.map.Singleton");
		s1.showly();		
		Singleton s2 = SingletonChild.getInstance("com.design.single.map.Singleton");
		s2.showly();
		SingletonChild s3 = (SingletonChild) SingletonChild.getInstance("com.design.single.map.SingletonChild");
		s3.showly();
	}

}
