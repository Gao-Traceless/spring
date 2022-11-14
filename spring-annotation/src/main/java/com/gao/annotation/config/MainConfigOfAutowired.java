package com.gao.annotation.config;


import com.gao.annotation.dao.BookDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：
 *      Spring利用依赖注入(DI)，完成对IOC容器中各个组件的依赖关系赋值
 * 1、@Autowired: 自动注入
 *      1.1、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDAO.class);找到就赋值
 *      1.2、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中找
 *                                  applicationContext.getBean("bookDAO")
 *      1.3、@Qualifier("bookDAO"): 使用@Qualifier自定需要装配的组件的id，而不是使用属性名
 *      1.4、自动装配默认一定要将属性赋值好，没有就会报错
 *           可以使用@Autowired(required = false);
 *      5、@Primary: 让Spring进行自动装配的时候，默认使用首先的bean；
 *           也可以继续使用@Qualifier指定需要装配的bean的名字
 *      BookService{
 *          @Autowired
 *          BookDAO bookDAO;
 *      }
 * 2、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 *   @Rsource:
 *         可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的
 *         没有能支持@Primary功能没有支持@Autowired(required = false)
 *   @Inject:
 *         需要导入javax.inject的包和Autowired的功能一样，没有required = false的功能
 *   区别：
 *      @Autowired: spring定义的；@Rsource、@Inject都是java规范
 *  AutowiredAnnotationBeanPostProcessor: 解析完成自动装配功能
 * 3、@Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值
 *      3.1、[标注在方法位置]: @Bean+方法参数；参数从容器中获取；默认不写@Autowired效果是一样的；都能自动装配
 *      3.2、[标注在构造器上]: 如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *      3.3、[放在参数位置]:
 * 4、自定义组件想要使用spring容器底层的一些组件(ApplicationContext,BeanFactory,xxx);
 *    自定义组件实现xxxAware: 在创建对象的时候，会调用接口规定的方法注入相关组件；Aware
 *    把Spring底层一些组件注入到自定义的Bean中；
 *    xxxAware: 功能使用xxxProcessor
 *      ApplicationContextAware==》ApplicationContextAwareProcessor
 *
 */
@Configuration
@ComponentScan({"com.gao.annotation.dao", "com.gao.annotation.service", "com.gao.annotation.controller","com.gao.annotation.bean"})
public class MainConfigOfAutowired {

//    @Bean("bookDAO2")
//    @Bean //@Bean标注的方法创建对象的时候，方法参数的值从容器中获取
//    public BookDAO bookDAO(){
////        BookDAO bookDAO = new BookDAO();
////        bookDAO.setLable("2");
//        return new BookDAO();
//    }


}
