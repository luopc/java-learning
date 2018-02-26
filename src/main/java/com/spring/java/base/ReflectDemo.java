package com.spring.java.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.spring.java.base.Car");
        try {
            Constructor cst = clazz.getDeclaredConstructor((Class[]) null);
            Car car = (Car) cst.newInstance();
            
            Method setBrand = clazz.getMethod("setBrand", String.class);
            setBrand.invoke(car, "宝马");
            Method setColor = clazz.getMethod("setColor", String.class);
            setColor.invoke(car, "银色");
            Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
            setMaxSpeed.invoke(car, 120);
            System.out.println(car);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}

class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    // ①默认构造函数
    public Car() {
    }

    // ②带参构造函数
    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    // ③未带参的方法
    public void introduce() {
        System.out.println("brand:" + brand + ";color:" + color + ";maxSpeed:" + maxSpeed);
    }
    // 省略参数的getter/Setter方法

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
    }
    
    

}