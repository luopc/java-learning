package com.luopc.thead2.condition;

import java.util.List;

/**
 * 消费者
 * @author luopc
 *
 */
public class SimpleConsumer implements Runnable {
    
    private List<String> products ;
    
    public SimpleConsumer(List<String> products) {
        super();
        this.products = products;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(products) {
                if(products.size() == 0) {
                    System.out.println("仓库现在是空的了");
                    try {
                        products.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    String product = products.remove(0);
                    System.out.println(product + "已经被消费掉了~");
                    products.notifyAll();
                }
            }
        }
    }

}
