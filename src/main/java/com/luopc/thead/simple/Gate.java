package com.luopc.thead.simple;

public class Gate {
	private int count;
	private String name;
	private String address;

	public void pass(String name, String address) {
		this.count++;
		this.name = name;
		this.address = address;

		check();
	}

	public void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("*******BROKEN *******:" + toString());
		}
	}

	@Override
	public String toString() {
		return "No." + count + " " + name + ", " + address;
	}
}
