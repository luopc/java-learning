package com.luopc.reflex.emp.entity;

public class Emp {

	private String name;
	private String job;

	private Dept dept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}


	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", job=" + job + ", dept=" + dept + "]";
	}

	
}
