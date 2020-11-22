package com.luopc.base.collect;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashSetDemo {
    
    public static void main(String[] args) {
        Set<Person> ts = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ts.add(new Person("No." + i, random.nextInt(100)));
        }
        System.out.println(ts);
    }

}
