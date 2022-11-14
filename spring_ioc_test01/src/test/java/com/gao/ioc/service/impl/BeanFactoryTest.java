package com.gao.ioc.service.impl;


import com.gao.ioc.dao.UserDAO;
import com.gao.ioc.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {


    public static void main(String[] args) {

        //创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建读取器(读取xml文件)
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //读取器读取配置文件给工厂
        reader.loadBeanDefinitions("beans.xml");
        //根据id获取bean实例对象
        UserService userService = (UserService) beanFactory.getBean("userService");
//        System.out.println(userService);

        UserDAO userDAO = (UserDAO) beanFactory.getBean("userDao");
//        System.out.println(userDAO);


    }


}