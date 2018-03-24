package com.luopc.base;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class IntegerMapTest {
	
	@Test
	public void test001() {
		Integer a1 = new Integer(456);
		Integer a2 = new Integer(456);
		System.out.println(a1==a2);
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		Map<Integer,Integer> map = new HashMap<>();
		map.put(a1, 5);
		System.out.println(a2);
	}

}
