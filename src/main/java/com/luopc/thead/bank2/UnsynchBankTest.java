package com.luopc.thead.bank2;

public class UnsynchBankTest {

	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
		int i = 0;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunable tr = new TransferRunable(bank, i, INITIAL_BALANCE);
			Thread t = new Thread(tr);
			t.start();
		}
	}

}

class TransferRunable implements Runnable {

	private final Bank b;
	private int formAccount;
	private double maxAmount;
	private int DELAY = 10;

	public TransferRunable(Bank b, int from, double max) {
		this.b = b;
		this.formAccount = from;
		this.maxAmount = max;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int toAccount = (int) (b.size() * Math.random());
				double amount = maxAmount * Math.random();
				b.transfer(formAccount, toAccount, amount);
				Thread.sleep((long) (DELAY * Math.random()));
			}
		} catch (InterruptedException e) {

		}

	}

}

class Bank {

	// private final int count;
	//
	// private final double initial;

	private final double[] accounts;// 银行总存款

	public Bank(int count, double initial) {
		accounts = new double[count];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initial;
		}
	}

	/**
	 * 转账方法
	 * 
	 * @param from
	 * @param to
	 * @param amount
	 */
	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount)
			return;
		System.out.println(Thread.currentThread().getName());
		accounts[from] -= amount;
		System.out.printf("%10.2f from %d to %d \n", amount, from, to);
		accounts[to] += amount;
		System.out.printf("Total Balance: %10.2f \n", getTotal());
	}

	/**
	 * 计算总金额
	 * 
	 * @return
	 */
	private double getTotal() {
		double rs = 0;
		for (double d : accounts) {
			rs += d;
		}
		return rs;
	}

	public int size() {
		return accounts.length;
	}

}