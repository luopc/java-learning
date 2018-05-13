package com.luopc.base;

public class OuterInnerDemo {

	private int size = 10;

	public class Inner {
		private int size = 11;
		public int getSize() {
			return size;
		}
	}
	
	private class SelfInner {
		private int size = 12;
		public int getSize() {
			return size;
		}
	}

	public static void main(String[] args) {
		Inner in = new OuterInnerDemo().new Inner();//
		System.out.println(in.getSize());//调用内部类的public方法
		System.out.println(in.size);//调用内部类的private属性
		System.out.println("------------------------------");
		SelfInner sin = new OuterInnerDemo().new SelfInner();
		System.out.println(sin.getSize());
		System.out.println(sin.size);
	}

}
