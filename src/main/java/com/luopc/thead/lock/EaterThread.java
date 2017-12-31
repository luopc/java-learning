package com.luopc.thead.lock;

public class EaterThread extends Thread {

	private String name;

	private final Tool lock_01;

	private final Tool lock_02;

	public EaterThread(String name, Tool lock_01, Tool lock_02) {
		this.name = name;
		this.lock_01 = lock_01;
		this.lock_02 = lock_02;		
	}

	public void run() {
		while (true) {
			ru();
		}
	}

	public void ru() {
		synchronized (lock_01) {
			System.out.println(name + "获得了第一个钥匙：" + lock_01);
			synchronized (lock_02) {
				System.out.println(name + "获得了第二个钥匙：" + lock_02);
				System.out.println(name + "开1号锁~");
				System.out.println(name + "释放第一把钥匙：" + lock_01);
				System.out.println(name + "释放第二把钥匙：" + lock_02);	
			}
		}
		synchronized (lock_02) {
			System.out.println(name + "获得了第二个钥匙：" + lock_02);
			synchronized (lock_01) {
				System.out.println(name + "获得了第一个钥匙：" + lock_02);
				System.out.println(name + "开2号锁");
				System.out.println(name + "释放第二把钥匙：" + lock_01);
				System.out.println(name + "释放第一把钥匙：" + lock_02);	
			}
		}		
		
	}
}
