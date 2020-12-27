package com.spring.learn.util;

import com.spring.learn.init.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization()方法");
                car.setColor("red");
            }
        }
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() > 120) {
                car.setMaxSpeed(120);
                System.out.println("调用MyBeanPostProcessor的postProcessAfterInitialization()方法");
            }
        }
        return bean;
    }
}
