package com.gao.annotation.ext;

import com.gao.annotation.bean.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量：" + configurableListableBeanFactory.getBeanDefinitionCount());

    }

    //BeanDefinitionRegistry bean定义信息的保存中心,以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例；
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量:" + beanDefinitionRegistry.getBeanDefinitionCount() );

//        RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();

        beanDefinitionRegistry.registerBeanDefinition("hello", beanDefinition);


    }


}
