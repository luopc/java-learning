package com.luopc.weakReference;

/**
 * http://www.cnblogs.com/xrq730/p/4854705.html
 * 
 * @author cheng java 弱引用~
 * 
 * 对于WeakReference，在下一次GC的时候，一定会回收，无论内存是否满。
 *
 */
public class WeakReferenceCarTest {

	public static void main(String[] args) {
		Car car = new Car(2000.0, "red");
		WeakReferenceCar wrc = new WeakReferenceCar(car);
		// wrc.
		int i = 0;
		while (true) {
			if (wrc.get() != null) {
				i++;
				System.out.println("WeakReferenceCar's Car is alive for " + i + ", loop - " + wrc);
			} else {
				System.out.println("WeakReferenceCar's Car has bean collected");
				break;
			}
		}

	}

}
