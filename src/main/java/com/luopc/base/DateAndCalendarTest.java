package com.luopc.base;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class DateAndCalendarTest {
	
	
	@Test
	public void test001() {
		Instant ins = Instant.now();
		System.out.println(ins);
		
		LocalDate nowDate = LocalDate.now();
		System.out.println(nowDate);
		LocalDate nextWeek = nowDate.plus(1, ChronoUnit.WEEKS);
		System.out.println(nextWeek);
		
		LocalDate previousYear = nowDate.minus(1, ChronoUnit.YEARS);
		System.out.println("Date before 1 year : " + previousYear);
		LocalDate nextYear = nowDate.plus(1, ChronoUnit.YEARS);
		System.out.println("Date after 1 year : " + nextYear);

		
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM:ss");  
		System.out.println(nowDateTime.format(formatter));
	}

}
