package com.luopc.thead.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private Long count = 0L;

	private List<Card> cards = new ArrayList<>();
	
	public Bank(int cardSize, int count) {		
		for (int i = 0; i < cardSize; i++) {
			Card card = new Card("card"+i,count);
			cards.add(card);
		}
		count = cardSize*count;
	}

	public synchronized boolean quMoney(int i,int m) {
		Card card = cards.get(i);
		int money = card.getMoney();
		if (m > money) {
			System.out.println("余额不足~");
			return false;
		} else {
			money -= m;
			card.setMoney(money);
		}
		return true;
	}

	public synchronized void  cunMoney(int j,int m) {
		Card card = cards.get(j);
		int money = card.getMoney();
		money += m;
		card.setMoney(money);
		
	}
	
	public String getString() {		
		return "Bank 共有[" + count + "]钱!";
	}
}
