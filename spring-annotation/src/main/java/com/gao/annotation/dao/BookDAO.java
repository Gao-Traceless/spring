package com.gao.annotation.dao;

import org.springframework.stereotype.Repository;

//名字默认是类名首字母小写
@Repository
public class BookDAO {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDAO{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
