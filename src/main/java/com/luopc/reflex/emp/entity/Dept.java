package com.luopc.reflex.emp.entity;

public class Dept {
	
	private String name;
	
	private String loc;
	
	private Company company = new Company();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Dep [name=" + name + ", loc=" + loc + ", company=" + company + "]";
	}
	

	
	

}
