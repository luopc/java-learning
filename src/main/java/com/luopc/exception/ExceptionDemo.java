package com.luopc.exception;

import org.junit.Test;

public class ExceptionDemo {
	
	@Test
	public void test001() {
		int[] a = {1,2,3,4};
        System.out.println(a[4]);
        System.out.println("我执行了吗???");
	}
	
	@Test
	public void test002() {
		try {
			int[] a = {1,2,3,4};
	        System.out.println(a[4]);
	        System.out.println("我执行了吗???");
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}

}
