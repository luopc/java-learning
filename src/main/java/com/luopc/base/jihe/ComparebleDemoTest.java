package com.luopc.base.jihe;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class ComparebleDemoTest {

	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();

		Random rd = new Random();
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setName("NO." + i);
			u.setAge((int) (rd.nextInt(100)));

			userList.add(u);
			userList.add(u);
		}
		System.out.println(userList);
		Collections.sort(userList);
		System.out.println(userList);
	}

	@Test
	public void test002() {
		List<Students> sList = new ArrayList<Students>();

		Random rd = new Random();
		for (int i = 0; i < 10; i++) {
			Students t = new Students();
			t.setName("NO." + i);
			t.setScore((int) (rd.nextInt(100)));

			sList.add(t);
//			sList.add(t);
		}
		System.out.println(sList);
		
//		Comparator comparator  = (a, b) -> ((Students)a).getScore() - ((Students)b).getScore();
//		Comparator<Students> comparator  = (a, b) -> a.getScore() - b.getScore();
		Collections.sort(sList, (a, b) -> ((Students)a).getScore() - ((Students)b).getScore());
		System.out.println(sList);
	}

}

class User implements Comparable<User> {

	private String name;

	private int age;

	@Override
	public int compareTo(User o) {
		// if(this.getAge() == o.getAge()) return -1;
		// else
		return this.getAge() - o.getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}

class Students {

	private String name;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", score=" + score + "]";
	}
}