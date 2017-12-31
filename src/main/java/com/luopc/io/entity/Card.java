package com.luopc.io.entity;

import java.io.Serializable;

public class Card implements Serializable {

	private static final long serialVersionUID = 7750279806805270970L;
	private String cardNum;
	private double mony;

	public Card() {
		super();
	}

	public Card(String cardNum, double mony) {
		super();
		this.cardNum = cardNum;
		this.mony = mony;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public double getMony() {
		return mony;
	}

	public void setMony(double mony) {
		this.mony = mony;
	}

}
