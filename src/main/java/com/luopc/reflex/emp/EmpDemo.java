package com.luopc.reflex.emp;

import com.luopc.reflex.emp.action.EmpAction;

public class EmpDemo {

	public static void main(String[] args) {
		String vlue = "emp.name:lisi|emp.job:clerk|emp.dept.name:财务部|emp.dept.company.name:腾讯";
		EmpAction action = new EmpAction();
		action.setValue(vlue);
		System.out.println(action.getEmp());

	}

}
