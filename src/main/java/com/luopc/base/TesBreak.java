package com.luopc.base;

public class TesBreak {

	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
			out: 
			for (int j = 0; j < 50; j++) {
				if (j > 2) {
					break out;
				}else {
					System.out.println(i +"|" + j);
				}
			}
		}

	}

}
