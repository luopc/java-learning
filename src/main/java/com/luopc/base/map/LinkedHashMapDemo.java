package com.luopc.base.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		Map<String, Object> a1 = new LinkedHashMap<>();
		// a1.put("a", "22");
		a1.put("b", "33");
		a1.put("c", "44");
		a1.put("d", "55");
		a1.put("a", "66");

		for (Map.Entry<String, Object> ob : a1.entrySet()) {
			System.out.println(ob.getKey());
		}
		System.out.println("-------------------");
		List<Entry<String, Object>> infos = new ArrayList<Map.Entry<String, Object>>(a1.entrySet());

		for (int i = infos.size(); i > 0; i--) {
			System.out.println(infos.get(i - 1).getKey());
		}
		
		
	}

}
