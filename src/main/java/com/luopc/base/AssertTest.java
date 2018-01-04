package com.luopc.base;

import org.junit.Test;

public class AssertTest {

	public static void main(String[] args) {
		assert 1 + 1 == 2;
		System.out.println("assert1 is OK");
		assert 1 + 1 == 3:"assert faild";
		System.out.println("assert2 is OK");

	}
	
	@Test
	public void test() {
		int i = 1;
		System.out.println(i+++i++);//1+2
		System.out.println("i=" + i);//3
		System.out.println(i+++ ++i);//3 + 5
		System.out.println("i=" + i);//5
		System.out.println(i+++i+++i++);//5 + 6 + 7
		System.out.println("i=" + i);//8
	}
	
	@Test
	public void test01() {
		int i = -4;
		int j = 4;
		System.out.println("----------- int >> :" + i +"|j:" + j);
		System.out.println("erjinzhi-start:" + Integer.toBinaryString(i));
		System.out.println("erjinzhi-start:" + Integer.toBinaryString(j));
		i >>= 1;
		j >>= 1;
		System.out.println("erjinzhi-end:"+Integer.toBinaryString(i));
		System.out.println("erjinzhi-end:"+Integer.toBinaryString(j));
		System.out.println("----------- int >> :" + i +"|j:" + j);
	}

}
