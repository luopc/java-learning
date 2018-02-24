package com.luopc.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticDemo {

    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    // 然后可以这样创建一个Map：
    public static void main(String[] args) {
        Map<String, List<Person>> personMap = StaticDemo.map();
    }

}
