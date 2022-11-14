package com.gao.ioc.service.impl;

import com.gao.ioc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassPathXmlApplicationContext: 加载类路径下的xml配置文件的ApplicationContext
 * FileSystemXmlApplicationContext: 加载磁盘路径下的xml配置的ApplicationContext
 * AnnotationConfigApplicationContext: 加载注解配置类的ApplicationContext
 */
public class ApplicationContextTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);

    }

}
