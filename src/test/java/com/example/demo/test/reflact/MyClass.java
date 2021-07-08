package com.example.demo.test.reflact;

class MyClass {
    // 私有属性，只可以调用set方法修改
    private String name;

    private void printName() {
        // 私有方法，只有本类自己的实例可以调用
        System.out.println("My name is " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}