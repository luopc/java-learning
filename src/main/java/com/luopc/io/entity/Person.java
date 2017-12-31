package com.luopc.io.entity;

import java.io.Serializable;
import java.util.Date;

import com.luopc.io.clone.SerialCloneable;

public class Person extends SerialCloneable implements Serializable, Cloneable {

	private static final long serialVersionUID = -839434637333424438L;

	private String name;
	private int age;
	private Date createDate;
	private Card card;

	public Person() {
		super();
	}

	public Person(String name, int age, Date createDate, Card card) {
		super();
		this.name = name;
		this.age = age;
		this.createDate = createDate;
		this.card = card;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "[name=" + name + ",age=" + age + ":hasMony=" + card.getMony() + "]";
	}

}
