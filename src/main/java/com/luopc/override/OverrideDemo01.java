package com.luopc.override;

public class OverrideDemo01 {

	public static void main(String[] args) {
		C c = new C();
		c.foo();
		
		A.fooS();
		B.fooS();
		C.fooS();
	}

}

class A {

	private int a = 200;
	protected int i = 100;
	protected static int b = 10000;
	
	private void foo() {
		System.out.println("is foo at A");
	}
	
	public void fooA() {
		System.out.println("a = " + a);
	}
	
	public static void fooS() {
		System.out.println("I is foos at A");
	}
}

class B extends A {
	protected int i = 1000;
}

class C extends B {
	private int i = 10000;

	public void foo() {
		System.out.println("this.i:" + this.i); // 10000

		System.out.println("B.this.i:" + ((B) this).i); // 1000

		System.out.println("A.this.i:" + ((A) this).i); // 100
		
//		System.out.println("a = " + a); //报错
		
		System.out.println("b = " + b); //
	}
	
	public static void fooS() {
		System.out.println("I is foos at C");
	}
}