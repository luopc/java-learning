package com.luopc.thead.bank;

import org.junit.Test;

public class BankTest {

	@Test
	public void test() {
		Bank b = new Bank(100, 1000);
		zhuangzhangThread zz = new zhuangzhangThread(b);
		for (int i = 0; i < 100; i++) {
			new Thread(zz).start();
		}

	}

}

class zhuangzhangThread implements Runnable {

	private final Bank bank;

	public zhuangzhangThread(Bank b) {
		bank = b;
	}

	@Override
	public void run() {
		
		while (true) {
			int to = (int) (100 * Math.random()) ;
			int from = (int) (100 * Math.random()) ;				
			int money = (int) (100 * Math.random());
			if (bank.quMoney(from,money)) {
				bank.cunMoney(to,money);
				System.out.println(bank.getString());
			}
			
		}
		
	}

}