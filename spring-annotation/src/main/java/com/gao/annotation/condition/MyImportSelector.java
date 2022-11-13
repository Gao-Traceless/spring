package com.gao.annotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {


    //返回值，就是导入到容器中的组件全类名
    //AnnotationMetadata: 当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

//        annotationMetadata
        //方法不要返回null值,可以返回一个空数组如return new String[0]
        return new String[]{"com/gao/annotation/bean/Blue","com/gao/annotation/bean/Yellow"};
    }
}
