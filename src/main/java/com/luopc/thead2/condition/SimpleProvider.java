package com.luopc.thead2.condition;

import java.util.List;
import java.util.Random;

/**
 * 生产者
 * @author luopc
 *
 */
public class SimpleProvider implements Runnable {
    
    private List<String> products ;
    
    private int maxNum;

    public SimpleProvider(List<String> products, int maxNum) {
        this.products = products;
        this.maxNum = maxNum;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(products) {
                if(products.size() == maxNum) {
                    System.out.println("仓库已满~");
                    try {
                        //生产满了，则停止生产
                        products.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    Random rd = new Random();
                    String product = "NO."+rd.nextInt(maxNum*10);
                    System.out.println("仓库新增了；"+product);
                    products.add(product);
                    //已经生产了产品，提示其他客户进行消费
                    products.notifyAll();
                }
            }
        }

    }

}
