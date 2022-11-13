package org.gao;

import static org.junit.Assert.assertTrue;

import com.gao.annotation.bean.Blue;
import com.gao.annotation.bean.Person;
import com.gao.annotation.config.MainConfig;
import com.gao.annotation.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class IOCTest{
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @SuppressWarnings("resource")
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }


    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
       /* String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }

        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1 == person2);*/
        System.out.println("IOC容器创建完成....");
        Object person1 = applicationContext.getBean("person");

    }

    @Test
    public void test03(){
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        //拿到运行环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        for (String name : beanNamesForType){
            System.out.println(name);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void testImport(){
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        //工厂bean获取的是调用getObject创建的对象
        Object colorFactoryBean1 = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型： " + colorFactoryBean1.getClass());
        System.out.println(colorFactoryBean1 ==colorFactoryBean2);
        Object colorFactoryBean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("======="+ colorFactoryBean3.getClass());


    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }



}
