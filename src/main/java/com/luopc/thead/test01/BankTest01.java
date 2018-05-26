package com.luopc.thead.test01;

public class BankTest01 {

	private Bank bank;

	public static void main(String[] args) {
		Bank b = new Bank(100, 1000);
		for (int i = 0; i < 10; i++) {
			zhuangzhangThread r = new zhuangzhangThread(b, i, 1000);
			Thread t = new Thread(r);
			t.start();
		}
	}

}

class Bank {

	private final double[] zhanghus;

	public Bank(int n, double mony) {
		zhanghus = new double[n];
		for (int i = 0; i < zhanghus.length; i++) {
			zhanghus[i] = mony;
		}
	}

	public void zuanzhang(int from, int to, double jine) {
		if (zhanghus[from] < jine)
			return;
		System.out.print(Thread.currentThread());
		zhanghus[from] -= jine;
		System.out.printf("从[ %d ]转走 %10.2f 钱到[ %d ]", from, jine, to);
		zhanghus[to] += jine;
		System.out.printf("金库的总金额为：%10.2f ", getZongJine());
		System.out.println();
	}

	public double getZongJine() {
		double sum = 0;
		for (double d : zhanghus) {
			sum += d;
		}
		return sum;
	}

	public int getZanghuSize() {
		return zhanghus.length;
	}
}

class zhuangzhangThread implements Runnable {

	private Bank bank;
	private int fromzh;
	private double maxq;

	public zhuangzhangThread(Bank b, int from, double max) {
		bank = b;
		fromzh = from;
		maxq = max;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int to = (int) (bank.getZanghuSize() * Math.random());
				double amout = maxq * Math.random();
				bank.zuanzhang(fromzh, to, amout);
				Thread.sleep((int) (10 * Math.random()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	

}
