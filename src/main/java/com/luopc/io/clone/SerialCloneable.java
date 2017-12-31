package com.luopc.io.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialCloneable implements Serializable, Cloneable {

	private static final long serialVersionUID = -2167327824425342502L;

	@Override
	public Object clone() throws CloneNotSupportedException {
		ByteArrayOutputStream boot = new ByteArrayOutputStream();
		try {
			ObjectOutputStream out = new ObjectOutputStream(boot);
			out.writeObject(this);
			out.close();

			ByteArrayInputStream bin = new ByteArrayInputStream(boot.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bin);
			Object ret = in.readObject();
			in.close();
			return ret;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return super.clone();
	}

}
