package com.gao.ioc.service.impl;

import com.gao.ioc.dao.UserDAO;
import com.gao.ioc.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl实例化");
    }

    //BeanFactory去调用该方法，从容器中获得userDao设置此处
    public void setUserDao(UserDAO userDao){
        System.out.println("BeanFactory去调用该方法获得userDao设置此处" + userDao);
        this.userDAO = userDao;
    }

}
