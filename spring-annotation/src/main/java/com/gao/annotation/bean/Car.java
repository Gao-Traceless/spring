package com.gao.annotation.bean;

import org.springframework.stereotype.Component;

public class Car {

    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car ... init ...");
    }

    public void detory(){
        System.out.println("car ... detory ...");
    }

}