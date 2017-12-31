package com.luopc.base;

class B {
	static {
		System.out.println("is B static-1");
	}
	{
		System.out.println("is B {}");
	}

	public B() {
		System.out.println("is B B()");
	}
	static {
		System.out.println("is B static-2");
	}
}

public class Base extends B {

	static {
		System.out.println("is Base static ");
	}
	{
		System.out.println("is Base {}");
	}

	public Base() {
		System.out.println("is Base base()");
	}

	public static void main(String[] args) {
		System.out.println("is Base main-1");
		new Base();
		System.out.println("is Base main-2");
	}
}
