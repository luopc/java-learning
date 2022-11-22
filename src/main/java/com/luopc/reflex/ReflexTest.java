package com.luopc.reflex;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

class Student {
	private String name;
	private int age;

	public Student() {
		super();
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + "]";
	}

}

public class ReflexTest {

	@Test
	public void test01() throws ClassNotFoundException {
		Student student = new Student();
		Class<?> cls1 = student.getClass();
		Class cls3 = Class.forName("com.luopc.reflex.Student");
		Class cls = Student.class;
		
		// Method [] mts = cls.getMethods();//
		Method[] mts = cls.getDeclaredMethods();//
		for (int i = 0; i < mts.length; i++) {
			Method m = mts[i];
			System.out.println(m.getName());
		}
		System.out.println("-----------------------------");
		System.out.println(cls1 == cls);
		System.out.println(cls1 == cls3);
		System.out.println(cls3 == cls);
		
		System.out.println(cls1.getPackage().getName());
		try {
			
//			if(student instanceof Student) {
				Student stu1 = (Student) cls.newInstance();
				System.out.println(stu1);
//			}
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void test02() throws ClassNotFoundException {
		Class cls = Class.forName("com.luopc.reflex.Student");
		Method[] mts = cls.getDeclaredMethods();//
		for (int i = 0; i < mts.length; i++) {
			Method m = mts[i];
			Class returnType = m.getReturnType();
			System.out.print(returnType.getSimpleName() + " ");
			System.out.print(m.getName() + "(");
			
			Class [] params = m.getParameterTypes();
			for (int j = 0; j < params.length; j++) {
				if(j > 0)System.out.print(",");
				System.out.print(params[j].getName() + " arg"+j);
			}
			System.out.println(")");			
		}
	}
	
	@Test
	public void test03() throws ClassNotFoundException {
		Class cls = Class.forName("com.luopc.reflex.Student");
		Field [] fs = cls.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Class fieldType = fs[i].getType();
			System.out.print(fieldType + "  ");
			System.out.println(fs[i].getName());
		}
	}

	@Test
	public void test04() throws ClassNotFoundException {
		Class cls = Class.forName("com.luopc.reflex.Student");
		Constructor [] cts = cls.getDeclaredConstructors();
		for (int i = 0; i < cts.length; i++) {
		
			System.out.print(cts[i].getName() +"(");
			Class[] params = cts[i].getParameterTypes();
			for (int j = 0; j < params.length; j++) {
				if(j > 0)System.out.print(",");
				System.out.print(params[j].getName() + " arg"+j);
			}
			System.out.println(")");	
		}
	}
	
	@Test
	public void test05() throws ClassNotFoundException{
		Class cls = Class.forName("com.luopc.reflex.Student");
//		Student st = new Student();
//		Class cls = st.getClass();
		
		try {
			Object obj = cls.newInstance();
			Method method = cls.getMethod("setAge", int.class);
			method.invoke(obj, 25);
			System.out.println(obj);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void testAnnotation() throws ClassNotFoundException {
	    Class c = Class.forName("com.luopc.annotation.mooc.Child");
	    Annotation[] as = c.getAnnotations();
	    for (int i = 0; i < as.length; i++) {
	        Annotation ant = as[i];
	        System.out.println(ant.annotationType().getName());
	        Object ob = c.getAnnotation(Class.forName(ant.annotationType().getName()));
	        System.out.println(ob);
        }
	    
	    Method[] mt = c.getDeclaredMethods();
	    for (int i = 0; i < mt.length; i++) {
            Method mo = mt[i];
            System.out.println(mo.getReturnType());
            System.out.println(mo.getName());
//            System.out.println(mo.getParameterTypes());
            
            Annotation[] mtas = mo.getAnnotations();
            for (int j = 0; j < mtas.length; j++) {
                Annotation mta = mtas[j];
                System.out.println(mta.annotationType().getName());
            }
        }
	    
	    
	}
}
