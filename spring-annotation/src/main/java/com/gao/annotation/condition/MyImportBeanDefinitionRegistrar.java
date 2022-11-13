package com.gao.annotation.condition;

import com.gao.annotation.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /*
    * annotationMetadata: 当前类的注解信息
    * BeanDefinitionRegistry: BeanDefinition注册类
    *       把所有需要添加到容器中的bean；调用BeanDefinitionRegistry.registerBeanDefinition手动注册进来
    * */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.gao.annotation.bean.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.gao.annotation.bean.Blue");
        if (red && blue){
            //指定bean的定义信息；(Bean的类型，Bean的作用域，。。。)
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean，指定bean名
            beanDefinitionRegistry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }

}
