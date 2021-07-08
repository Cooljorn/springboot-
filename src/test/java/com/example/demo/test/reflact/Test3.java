package com.example.demo.test.reflact;
import java.util.ArrayList;

public class Test3 {
    /**
     * 打印对象的类名
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param o
     */
    public static void printClass(Object o) {
        System.out.printf(o.getClass().getName());
    }

    public static void main(String[] args) {
        printClass(new ArrayList<>());
    }
}

