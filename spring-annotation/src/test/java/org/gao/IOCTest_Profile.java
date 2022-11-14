package org.gao;

import com.gao.annotation.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    /*1、使用命令行动态参数: 在虚拟机参数位置加载(-Dspring.profiles.active=test)
    * 2、代码的方式激活某种环境;
    * */

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1、创建一个applicationContext


        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test", "dev");
        //3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name: beanNamesForType){
            System.out.println(name);
        }


        applicationContext.close();
    }

}
