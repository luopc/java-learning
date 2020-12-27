package com.spring.learn;

import com.spring.learn.init.Car;
import com.spring.learn.util.MyBeanPostProcessor;
import com.spring.learn.util.MyInstantiationAwareBeanPostProcess;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {

    private static void LifyCycleBeanFactory() {
        Resource resource = new ClassPathResource("learn-init-Car.xml");
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);
        reader.loadBeanDefinitions(resource);
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcess());
        Car car1 = (Car) beanFactory.getBean("car");
        car1.introduce();
        car1.setColor("红色");
        Car car2 = (Car) beanFactory.getBean("car");
        System.out.println("car1==car2:" + (car1 == car2));
        ((DefaultListableBeanFactory) beanFactory).destroySingletons();
    }

    public static void main(String args[]) {
        LifyCycleBeanFactory();
    }
}
