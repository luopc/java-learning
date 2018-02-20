package com.luopc.generics;

public class StaticTest {
	public static void main(String[] args) {
		GT<Integer> gti = new GT<Integer>();
		gti.var = 1;
		GT<String> gts = new GT<String>();
		gts.var = 2;
		System.out.println(gti.var);

		/**
		 * 编译后的代码为以下
		 * 由于经过类型擦除，所有的泛型类实例都关联到同一份字节码上，泛型类的所有静态变量是共享的。
			
		GT gti = new GT();
		GT.var = 1;
		GT gts = new GT();
		GT.var = 2;
		System.out.println(GT.var);
		*/
	}
}

class GT<T> {
	public static int var = 0;

	public void nothing(T x) {
	}
}