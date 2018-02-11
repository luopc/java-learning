package com.luopc.time;

import java.time.LocalDate;

import org.junit.Test;

public class TimeMethodDemo {

	@Test
	public void test01() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		int dayofyear = today.getDayOfYear();
		System.out.println("Now Date = " + today);
		System.out.println("Now Date-year = " + year);
		System.out.println("Now Date-month = " + month);
		System.out.println("Now Date-day = " + day);
		System.out.println("Now Date-dayofyear = " + dayofyear);
	}
	
	@Test
	public void test02() {
		LocalDate today = LocalDate.now();
		LocalDate dateOfBirth = LocalDate.of(2010, 02, 14);
		
		System.out.println(dateOfBirth);
		System.out.println(today.getYear() - dateOfBirth.getYear());
	}
}
