package com.luopc.thead2.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerDemo {

    public static void main(String[] args) {

        Exchanger<String> exc = new Exchanger<>();

        ExecutorService es = Executors.newCachedThreadPool();

        Runnable dq = () -> {
            try {
                Thread.sleep(((long) (Math.random() * 10000)));
                String result = exc.exchange("1000万");
                System.out.println("用1000万交换：" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable zs = () -> {
            try {
                Thread.sleep(((long) (Math.random() * 10000)));
                String result = exc.exchange("小乔");
                System.out.println("用小乔交换：" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        es.execute(dq);
        es.execute(zs);
        es.shutdown();

    }

}
