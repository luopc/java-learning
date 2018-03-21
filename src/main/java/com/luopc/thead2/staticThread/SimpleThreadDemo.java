package com.luopc.thead2.staticThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadDemo {
	static final RunMethod run = new RunMethod();

	public static void main(String[] args) {
		Runnable r1 = () -> {
			run.sysMethod();
		};
		Runnable r2 = () -> {
			run.simpleMethod();
		};
		Runnable r3 = () -> {
			run.staticMethod();
		};
		Runnable r4 = () -> {
			run.othSysMethod();
		};
		Runnable r5 = () -> {
			run.otherSysStaticMethod();
		};
		ExecutorService es = Executors.newCachedThreadPool();
		es.submit(r1);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		es.submit(r2);
		es.submit(r3);
		es.submit(r4);
		es.submit(r5);
		es.shutdown();
	}

}

class RunMethod {

	public synchronized void sysMethod() {
		System.out.println("begin calling syschronized");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("sys getMessage");
		}
		System.out.println("sys finish");

	}

	public void simpleMethod() {
		System.out.println("simple method~");
	}

	public static void staticMethod() {
		System.out.println("static Method~");
	}
	
	public synchronized void othSysMethod() {
		System.out.println("otherSysMethod start");
	}
	public static synchronized void otherSysStaticMethod() {
		System.out.println("otherSysStaticMethod start");
	}
}