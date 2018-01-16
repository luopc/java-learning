package com.design.decorator.wukong;

public class WukongDemo {

	public static void main(String[] args) {
		TheGreatestSage sage = new Monkey();

		TheGreatestSage bird = new Bird(sage);
		TheGreatestSage fish = new Fish(bird);
		fish.move();
		System.out.println("-------------------------");
		TheGreatestSage fish2 = new Fish(new Bird(sage));
		fish2.move();
	}

}
