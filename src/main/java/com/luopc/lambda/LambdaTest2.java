package com.luopc.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class LambdaTest2 {

	@Test
	public void test001() {
		IUtil<Integer, String> ut = (p) -> String.valueOf(p);
		String st = ut.toStr(10000);
		System.out.println(st.length());

		IUtil<Integer, String> util = String::valueOf;
		String str = util.toStr(10000);
		System.out.println(str.length());
	}

	@Test
	public void test002() {
		IUtil2<String> ut = () -> "hello".toUpperCase();
		String st = ut.toUp();
		System.out.println(st);

		IUtil2<String> util = "hello"::toUpperCase;
		String str = util.toUp();
		System.out.println(str);
	}

	@Test
	public void test003() {
		//功能形接口
		Function<Integer, String> fun = String::valueOf;
		System.out.println(fun.apply(1000000).length());

		IntFunction<String> fun2 = String::valueOf;
		System.out.println(fun2.apply(1000000).length());
	}

	@Test
	public void test004() {
		//消费形接口
		System.out.println("hello word!");
		Consumer<String> cons =  System.out::println;
		cons.accept("hello word!");
	}

	@Test
	public void test005() {
		// 供给形接口
		Supplier<String> sup = "hello" :: toUpperCase;
		System.out.println(sup.get());
	}
	
	@Test
	public void test006() {
		//断言形接口
		Predicate<String> pre = "##hello" :: startsWith;
		System.out.println(pre.test("##"));
	}

}

interface IUtil<P, R> {
	public R toStr(P p);
}

interface IUtil2<R> {
	public R toUp();
}

interface IUtil3 {
	public int print(int x, int y);
}