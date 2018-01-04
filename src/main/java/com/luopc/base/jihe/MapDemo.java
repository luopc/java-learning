package com.luopc.base.jihe;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo {

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> treeMap = new TreeMap<String,Object>();
		Map<String,Object> hasTable = new Hashtable();

		Map<String, Object> cMap = new ConcurrentHashMap<>();
	}

}
