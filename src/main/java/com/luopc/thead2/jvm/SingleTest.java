package com.luopc.thead2.jvm;

/**
 * 测试编译的加载顺序
 * @author luopc
 *
 */
class Singleton {
    private static Singleton sin = new Singleton();
    public static int counter1;
    public static int counter2 = 0;

    private Singleton() {
        System.out.println("-----------");
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return sin;
    }
}

public class SingleTest {
    public static void main(String[] args) {
        Singleton sin = Singleton.getInstance();
        System.out.println(sin.counter1);
        System.out.println(sin.counter2);
    }
}
