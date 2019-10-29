package com.liuzp.jdk.jdk8;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 函数式编程
 * jdk1.8新特性 java.util.function
 */
public class FunctionUtil {

    public static void main(String[] args) {

        functionTest();
    }

    static void functionTest() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        //lambda表达式
        list.forEach((s)-> System.out.println(s));
        // 调用方法
        list.forEach(System.out::print);
    }
}
