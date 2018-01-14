package com.design.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ClonePrototype implements Cloneable,Serializable{
	
	private static final long serialVersionUID = -6002055180293933071L;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		oos.close();
		bos.close();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object ob = ois.readObject();
		ois.close();
		bis.close();
		return ob;
	}

}
