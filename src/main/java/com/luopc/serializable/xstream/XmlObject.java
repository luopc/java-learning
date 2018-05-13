package com.luopc.serializable.xstream;

public class XmlObject {
	private int count;
	private double price;
	private String phone;

	public XmlObject(int count, double price, String phone) {
		this.count = count;
		this.price = price;
		this.phone = phone;
	}

	public String toString() {
		return "count = " + count + ", price = " + price + ", phone = " + phone;
	}
}
