package com.luopc.base.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * 打印在数组中出现n/2以上的元素 利用一个HashMap来存放数组元素及出现的次数
 * 
 * @author erqing
 * 
 */
public class HashMapTest01 {

	public static void main(String[] args) {

		int[] a = { 2, 3, 2, 2, 1, 4, 2, 2, 2, 7, 9, 6, 2, 2, 3, 1, 0 };

		Map<Integer, Integer> intMap = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (intMap.containsKey(a[i])) {
				Integer va = intMap.get(a[i]);
				va++;
				intMap.put(a[i], va);
			} else {
				intMap.put(a[i], 1);
			}
		}
		// System.out.println(intMap);
		for (Map.Entry<Integer, Integer> et : intMap.entrySet()) {
			if (et.getValue() >= a.length / 2) {
				System.out.println(et.getKey());
			}
		}
	}

	@Test
	public void test002() {
		// System.out.println(1 << 4);
		// System.out.println(8>>>1);
		// System.out.println(8>>>2);
		// System.out.println(8>>>4);
		// System.out.println(8>>>8);
		//
		// int n = 12;
		// System.out.println(n + ":" + (n |= n>>>1));
		// System.out.println(n + ":" + (n |= n>>>2));
		// System.out.println(n + ":" + (n |= n>>>4));
		// System.out.println(n + ":" + (n |= n>>>8));
		// System.out.println(n + ":" + (n |= n>>>16));

		int r = tableSizeFor(8);
		System.out.println(r);

		r = tableSizeFor(12);
		System.out.println(r);

		r = tableSizeFor("Key".hashCode());
		System.out.println("Key".hashCode() + ":" + r);

		r = hash("Key".hashCode());
		System.out.println("Key".hashCode() + ":" + r);

		r = hash(8);
		System.out.println(r);

		r = hash(12);
		System.out.println(r);

		System.out.println((r & (16-1)));
	}

	int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= 2000) ? 2000 : n + 1;
	}

	int hash(int h) {
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
	
	@Test
	public void test003() {
		Map<String,String> hashTable = new Hashtable<>();
		hashTable.put("key", "value");
		hashTable.get("key");
		
		Map<String,String>  cMap = new ConcurrentHashMap<>();
	}
	
}
