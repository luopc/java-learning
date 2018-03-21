package com.learn.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整形数组，给定一个数，在数组中找出两个数的和等于这个数，并打印出来，我写的时间复杂度高，要求O(n)。
 * 
 * @author cheng
 *
 */
public class NumberDemo {

	public static void main(String[] args) {
		int[] array = { 12, 23, 45, 74, 15, 65, 11, 13, 22 };
		int num = 56;
		Map<Object, Integer> xMap = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			int x = array[i];
			int y = num - x;
			xMap.put(x, y);
		}

		for (int i = 0; i < array.length; i++) {
			if (xMap.containsValue(array[i])) {
				System.out.println(array[i] + "+" + xMap.get(array[i]));
			}
		}
	}

}
