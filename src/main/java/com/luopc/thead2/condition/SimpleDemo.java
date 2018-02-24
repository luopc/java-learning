package com.luopc.thead2.condition;

import java.util.LinkedList;
import java.util.List;

/**
 * 一个简单的生产消费模型
 * @author luopc
 *
 */
public class SimpleDemo {

    public static List<String> products = new LinkedList<>();


    public static void main(String[] args) {
        // for (int i = 0; i < 10; i++) {
        Thread d1 = new Thread(new SimpleProvider(products, 2));
        Thread d2 = new Thread(new SimpleConsumer(products));
        d1.start();
        d2.start();
        // }

    }

}
