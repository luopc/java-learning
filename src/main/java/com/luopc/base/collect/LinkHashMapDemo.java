package com.luopc.base.collect;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> maps = new LinkedHashMap<String, String>();
        maps.put("aa", "aa");
        
        maps.put("cc", "cc");
        maps.put("bb", "bb");

        for (Map.Entry entry : maps.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
