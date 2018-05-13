package com.luopc.SoftReference;

import java.lang.ref.SoftReference;

import com.luopc.weakReference.Car;

public class SoftReferenceCar extends SoftReference<Car>{

	public SoftReferenceCar(Car referent) {
		super(referent);
	}

}
