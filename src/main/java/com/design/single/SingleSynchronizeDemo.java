package com.design.single;

public class SingleSynchronizeDemo {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			int num = i;
			new Thread(()->{
				SingleCreator creator = SingleCreator.instance("No."+ num);
				creator.test001();
			}).start();
		}
		
		
	}

}

class SingleCreator{
	
	private static String name;
	
	private static SingleCreator creator;
	
	private SingleCreator(String name) {
		this.name = name;
	}
	public static  SingleCreator instance(String name) {
		if(creator == null) {
			initCreator(name);
		}
		return creator;
	}
	
	private static synchronized void initCreator(String name) {
		if(creator == null) {
			creator =  new SingleCreator(name);
		}
	}
	
	public void test001() {
		System.out.println("name=" + name);
	}
	
}
