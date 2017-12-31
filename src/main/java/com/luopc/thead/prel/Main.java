package com.luopc.thead.prel;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main Begin");
		Host host = new Host();
		host.request(10,'A');
		host.request(20,'A');
		host.request(30,'A');
		host.request(40,'A');
		System.out.println("Main End");

	}

}
