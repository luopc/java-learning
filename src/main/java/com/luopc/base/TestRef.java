package com.luopc.base;

public class TestRef {

	public static void main(String[] args) {
		Obj a = new Obj();
		Obj b = a;
		b.changeInt();
		System.out.println(a.getIntA());
		System.out.println(b.getIntA());

		Obj a1 = new Obj();
		Obj b1 = (Obj) a1.clone();
		b1.changeInt();
		System.out.println(a1.getIntA());
		System.out.println(b1.getIntA());
	}
}

class Obj implements Cloneable {
	private int IntA = 0;

	public int getIntA() {
		return IntA;
	}

	public void setIntA(int intA) {
		IntA = intA;
	}

	public void changeInt() {
		this.IntA = 1;
	}

	public Object clone() {
		Object o = null;

		try {
			o = (Obj) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;

	}

}
