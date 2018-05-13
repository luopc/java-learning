package com.luopc.thead2.jvm;

import java.util.Random;
/**
 * https://www.cnblogs.com/leesf456/p/5228922.html
 * @author cheng
 *
 */
class Init1 {
    static final int staticFinal1 = 1;
    static final int staticFinal2 = ReflexDemo.random.nextInt(100);
    static {
        System.out.println("init init1");
    }
}

class Init2 {
    static int staticNonFinal1 = 3;
    static {
        System.out.println("init init2");
    }
}

class Init3 {
    static int staticNonFinal1 = 5;
    static {
        System.out.println("init init3");
    }
}

public class ReflexDemo {
    public static Random random = new Random(47);

    public static void main(String[] args) {
        Class<?> clazzClass = Init1.class;
        System.out.println("after init init1 ref");
        System.out.println(Init1.staticFinal1);
        System.out.println(Init1.staticFinal2);

        System.out.println(Init2.staticNonFinal1);
        try {
            Class<?> clazz1 = Class.forName("com.luopc.thead2.jvm.Init3");
            System.out.println("after init init3 ref");
            System.out.println(Init3.staticNonFinal1);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
