package com.design.decorator.wukong;

public class Change implements TheGreatestSage {
	
	private TheGreatestSage sage;
	
	public Change(TheGreatestSage sage) {
		super();
		this.sage = sage;
	}



	@Override
	public void move() {
		sage.move();
	}

}
