package com.design.future.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureClient {

	public Data getRequest(String queryStr) {
		FutureData futureData = new FutureData();
		Runnable request = () -> {
			RealData realData = new RealData(queryStr);
			futureData.setRealData(realData);
		};
		ExecutorService es = Executors.newCachedThreadPool();
		es.submit(request);
		es.shutdown();
		String result = futureData.getRequest();
		System.out.println("result=" + result);
		return futureData;
	}

}
