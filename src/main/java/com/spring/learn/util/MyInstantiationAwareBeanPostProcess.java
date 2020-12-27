package com.spring.learn.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcess extends InstantiationAwareBeanPostProcessorAdapter {
    //    接口方法：在实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        //仅对容器中的car Bean处理
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation()方法");
        }
        return null;
    }

    //接口方法:实例化Bean之后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation()方法");
        }
        return true;
    }

    //    接口方法:在设置某个属性的时候调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor的postProcessPropertyValues()方法");
        }
        return pvs;
    }

}
