package com.luopc.reflex.emp.action;

import java.lang.reflect.InvocationTargetException;

import com.luopc.reflex.emp.entity.Emp;
import com.luopc.reflex.emp.util.BeanOperation;

public class EmpAction {
	
	private Emp emp = new Emp();
	
	public void setValue(String val) {
		try {
			BeanOperation.setBeanValue(this, val);
		} catch (NoSuchFieldException | SecurityException | NoSuchMethodException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

	public Emp getEmp() {
		return emp;
	}

}
