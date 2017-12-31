package com.luopc.thead.callable;

import java.util.concurrent.Callable;

class MyThread  implements Callable<String> {

	@Override
	public String call() throws Exception {		
		return "start call;";
	}
	 
}


public class CallTest{
	
}