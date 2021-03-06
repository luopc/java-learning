package com.luopc.base.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapTest {
	public static void main(String[] args) {
		Map<String, String> hashMaps = new HashMap<String, String>();
		Map<String, String> identityMaps = new IdentityHashMap<String, String>();
		hashMaps.put(new String("aa"), "aa");
		hashMaps.put(new String("aa"), "bb");

		identityMaps.put(new String("aa"), "aa");
		identityMaps.put(new String("aa"), "bb");

		System.out.println(hashMaps.size() + " : " + hashMaps);
		System.out.println(identityMaps.size() + " : " + identityMaps);
	}
}
