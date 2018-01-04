package com.luopc.base;

class BaseSub {
	private String $_helle;
	
	public void f() {
		System.out.println("Base");
	}
}

class Sub extends BaseSub{
	
	public void f() {
		System.out.println("Sub");
	}
}


public class FansTest {

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.luopc.base.Sub");
			BaseSub b = (BaseSub) c.newInstance();
			b.f();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
