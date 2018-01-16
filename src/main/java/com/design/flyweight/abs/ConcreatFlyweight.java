package com.design.flyweight.abs;

public class ConcreatFlyweight implements Flyweight {

	private Character intrinsicState = null;

	public ConcreatFlyweight(Character intrinsicState) {
		this.intrinsicState = intrinsicState;
	}

	@Override
	public void operation(String state) {
		System.out.println("intrinsic State = " + this.intrinsicState);
		System.out.println("Extrinsic State = " + state);
	}

}
