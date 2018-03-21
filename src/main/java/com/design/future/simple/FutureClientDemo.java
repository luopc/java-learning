package com.design.future.simple;

/**
 * 并行设计模式(一)-- Future模式
 * 
 * @author cheng
 *
 */
public class FutureClientDemo {

	public static void main(String[] args) {
		FutureClient fc = new FutureClient();
        Data data = fc.getRequest("get-value");
        System.out.println("请求完毕...");
        String result = data.getRequest();
        System.out.println("返回的结果:"+result);

	}

}
