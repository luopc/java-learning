package com.luopc.base;

public class RuntimeTest {

	public static void main(String[] args) {
		Runtime time = Runtime.getRuntime();
		System.out.print("max-1:" + byteToM(time.maxMemory()));//java虚拟机（这个进程）能构从操作系统那里挖到的最大的内存
		System.out.print(",free-1:" + byteToM(time.freeMemory()));//这些挖过来而又没有用上的内存，实际上就是 freeMemory()
		System.out.print(",total-1:" + byteToM(time.totalMemory()));//java虚拟机现在已经从操作系统那里挖过来的内存大小
		System.out.println("\n------------------------------");
		new Thread(new Runnable() {
			@Override
			public void run() {
				Long va = 0L;
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					va += i;
				}
				System.out.println("\n" + va);
			}
		}).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("max-2:" + byteToM(time.maxMemory()));
		System.out.print(",free-2:" + byteToM(time.freeMemory()));
		System.out.print(",total-2:" + byteToM(time.totalMemory()));
		time.gc();
		System.out.println("\n------------------------------");
		System.out.print("max-2:" + byteToM(time.maxMemory()));
		System.out.print(",free-2:" + byteToM(time.freeMemory()));
		System.out.print(",total-2:" + byteToM(time.totalMemory()));
	}

	public static double byteToM(Long num) {
		return num / 1024 / 1024;
	}
}
