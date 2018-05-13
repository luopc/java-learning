package com.luopc.weakReference;

import java.lang.ref.WeakReference;

public class WeakReferenceCar extends WeakReference<Car> {
	public WeakReferenceCar(Car car) {
		super(car);
	}
}
