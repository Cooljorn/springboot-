package com.example.demo.test.reflact;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test5 {
    /**
     * 调用一个对象的方法
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param o
     * @param methodName
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void callMethod(Object o, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = o.getClass().getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(o);
    }

    /**
     * 修改一个对象的属性
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param o
     * @param fieldName
     * @param value
     * @throws IllegalAccessException
     */
    public static void changeFieldValue(Object o, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field f = o.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(o, value);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        MyClass o = new MyClass();

        // 修改任意属性，即使是私有的
        changeFieldValue(o, "name", "二当家的白帽子");

        // 调用任意方法，即使是私有的
        callMethod(o, "printName");
    }
}

