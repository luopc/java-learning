package com.luopc.base.collect;

import java.util.NavigableMap;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

class Person implements Comparable<Person> {

	private String name;

	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if(this.age == o.age) {
			return this.name.compareTo(o.name);
		}else {
			return this.age - o.age;
		}
		
	}

	@Override
	public String toString() {

		return "[name=" + name + " ,age=" + age + "]";
	}

}

public class TreeSetDemo {

	public static void main(String[] args) {
		Set<Person> ts = new TreeSet<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			ts.add(new Person("No." + i, random.nextInt(100)));
		}
		System.out.println(ts);
	}
	
	@Test
	public void testNavigableMap() {
	  //NavigableMap extends SortedMap to provide useful navigation methods  
        NavigableMap<String,String> navigableMap = new TreeMap<String, String>();  
        
        navigableMap.put("C++", "Good programming language");  
        navigableMap.put("Java","Another good programming language");  
        navigableMap.put("Scala","Another JVM language");  
         navigableMap.put("Python","Language which Google use");  
         
        System.out.println("SorteMap : " + navigableMap);  
        
        //lowerKey returns key which is less than specified key  
        System.out.println("lowerKey from Java : " + navigableMap.lowerKey("Java"));  
        
        //floorKey returns key which is less than or equal to specified key  
        System.out.println("floorKey from Java: " + navigableMap.floorKey("Java"));  
        
        //ceilingKey returns key which is greater than or equal to specified key  
        System.out.println("ceilingKey from Java: " + navigableMap.ceilingKey("Java"));  
        
        //higherKey returns key which is greater specified key  
        System.out.println("higherKey from Java: " + navigableMap.higherKey("Java"));  
        
        
        //Apart from navigagtion methodk, it also provides useful method  
        //to create subMap from existing Map e.g. tailMap, headMap and subMap  
        
        //an example of headMap - returns NavigableMap whose key is less than specified  
        NavigableMap<String, String> headMap = navigableMap.headMap("Python", false);  
        System.out.println("headMap created form navigableMap : " + headMap);  
                
        //an example of tailMap - returns NavigableMap whose key is greater than specified  
        NavigableMap<String, String> tailMap = navigableMap.tailMap("Scala", false);  
        System.out.println("tailMap created form navigableMap : " + tailMap);  
        
        //an example of subMap - return NavigableMap from toKey to fromKey  
        NavigableMap<String,String> subMap = navigableMap.subMap("C++", false, "Python", false);  
        System.out.println("subMap created form navigableMap : " + subMap);  
	}

}
