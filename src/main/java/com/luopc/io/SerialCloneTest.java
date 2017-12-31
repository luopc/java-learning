package com.luopc.io;

import java.util.Date;

import com.luopc.io.entity.Card;
import com.luopc.io.entity.Person;


public class SerialCloneTest {

	public static void main(String[] args) {
		Person p1 = new Person("zhangsan", 23, new Date(), new Card("NO.1", 22.35));
		Person p2 = new Person("lisi", 23, new Date(), new Card("NO.2", 27.35));
		try {
			Person newp = (Person) p1.clone();
			
			p1.setAge(25);
			System.out.println(newp.toString());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
