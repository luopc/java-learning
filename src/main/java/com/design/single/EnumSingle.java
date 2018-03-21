package com.design.single;

public enum EnumSingle {

	INSTANCE;
	private Resource instance;

	EnumSingle() {
		instance = new Resource();
	}

	public Resource getInstance() {
		System.out.println("Enum single~");
		return instance;
	}

	public static void main(String[] args) {
		Resource rs1 = EnumSingle.INSTANCE.getInstance();
		Resource rs2 = EnumSingle.INSTANCE.getInstance();
		System.out.println(rs1 == rs2);
	}
}

class Resource {

	{
		System.out.println("init Resource~");
	}

}