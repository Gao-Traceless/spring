package com.gao.annotation.service;

import com.gao.annotation.config.MainConfig;
import com.gao.annotation.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BookService {

//    @Qualifier("bookDAO")
//    @Autowired(required = false)
    @Inject
    private BookDAO bookDAO2;

    public void print(){
        System.out.println(bookDAO2);
    }

    @Override
    public String toString(){
        return "BookService [bookDao=" + bookDAO2 + "]";
    }

}
