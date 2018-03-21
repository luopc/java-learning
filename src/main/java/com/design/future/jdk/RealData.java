package com.design.future.jdk;

import java.util.concurrent.Callable;

public class RealData implements Callable<String> {

	private String param;

	public RealData(String param) {
		this.param = param;
	}

	@Override
	public String call() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(param);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
