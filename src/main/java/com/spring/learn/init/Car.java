package com.spring.learn.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;
    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用Car的构造方法!!");
    }

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("调用SetBrand()设置属性");
    }


    public void setColor(String color) {
        this.color = color;
        System.out.println("调用SetColor()设置属性");
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        System.out.println("调用SetMaxSpeed()设置属性");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void introduce() {
        System.out.println("牌子:" + this.brand + " 颜色:" + this.color + " 速度:" + this.maxSpeed);
    }

    @Override
    public String toString() {
        return "牌子:" + this.brand + " 颜色:" + this.color + " 速度:" + this.maxSpeed;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory().");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的方法afterPropertiesSet()");
    }

    //通过<bean>的init-method属性所指定的初始化方法
    public void myInit() {
        System.out.println("调用init-method所指定的myInit()方法");
        this.maxSpeed = 240;
        this.brand = "蓝旗";
        this.color = "蓝色";
    }

    //通过<bean>的destory-method属性所指定的销毁方法
    public void myDestory() {
        System.out.println("调用destory-method所指定的myDestory()方法");

    }

}
