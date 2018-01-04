package com.luopc.thead;

public class ThreadSychronized {

	public static void main(String[] args) {
		new ThreadSychronized().init();
	}

	private void init() {
		// 在使用内部类创建对象之前，应该先有外部类对象，所以在18行这么调用。
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						// 睡一会，不然的话，一直疯狂打印，计算机会卡屏
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("nashinianshao");
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output3("qingkuang");
				}
			}
		}).start();
	}

	static class Outputer {
		//
		String pubObject = "";

		// 方法1：synchronize包在逻辑代码块外面，（）中的对象，可以用58行的pubObject作为两个线程的公共对象；也可以用“this”表示当前new的对象（效果同方法2）；当然也可以像现在这样，用类的字节码，这样的话，和方法3（静态方法，公共对象采用的肯定只有类的字节码了）效果就一样了
		public void output(String name) {
			int len = name.length();
			synchronized (Outputer.class) {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}

		// 方法2：synchronized直接写在方法名上即可（这样写的话，公共对象采用的就是23行new的对象）
		public synchronized void output2(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}

		// 方法3：静态方法，采用类字节码作为公共对象
		public static synchronized void output3(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
				System.out.println();
			}

		}
	}

}
