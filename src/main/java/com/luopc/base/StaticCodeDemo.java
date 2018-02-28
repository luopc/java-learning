package com.luopc.base;

public class StaticCodeDemo {
	public static void main(String[] args) {
		new StaticCode();//会输出"staiccode is loading"
		System.out.println(StaticCode.coutry);//不会输出"staiccode is loading"
	}
}
class StaticCode{	
	public static String coutry;
	{
		coutry = "China";
		System.out.println("staiccode is loading");	
	}
}
