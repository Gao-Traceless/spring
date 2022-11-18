package org.gao;

import com.gao.annotation.config.TxConfig;
import com.gao.annotation.ext.ExtConfig;
import com.gao.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Ext {


    @Test
    public void test01(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

        //发布事件；
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {});




        applicationContext.close();
    }

}
