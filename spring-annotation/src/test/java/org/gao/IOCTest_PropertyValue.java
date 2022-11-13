package org.gao;

import com.gao.annotation.bean.Person;
import com.gao.annotation.config.MainConfigOfLifeCycle;
import com.gao.annotation.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValue {

    //创建IOC容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01(){

        printBeans(applicationContext);
        System.out.println("==================================");

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        //下面这样也可以获取配置文件中的值
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);


        //关闭容器
        applicationContext.close();


    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }

}
