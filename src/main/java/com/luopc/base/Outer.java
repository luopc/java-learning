package com.luopc.base;

public class Outer {
	private int outProp = 8;

	class Inner {
		private int inProp = 5;
	}

	public void accessInnerProp() {
		System.out.println(new Inner().inProp);
	}

	public static void main(String[] args) {
		Outer p = new Outer();
		p.accessInnerProp();
		System.out.println("inProp:" + new Outer().new Inner().inProp);
	}
}
