package com.design.prototype;

public class Prototype extends ClonePrototype{
	
	private static final long serialVersionUID = -1594382200195838301L;

	private String name ;
	
	private int age;
	
	public StringBuilder address;
	

	public Prototype() {
		super();
	}

	public Prototype(String name, int age, StringBuilder address) {
		super();
		this.name = name;
		this.age = age;
		this.address = new StringBuilder(address);
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

	public StringBuilder getAddress() {
		return address;
	}

	public void setAddress(StringBuilder address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Prototype [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

}
