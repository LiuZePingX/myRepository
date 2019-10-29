package com.liuzp.jdk.jdk8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Title:
 * @Description: JDK1.8新特性学习
 * @author liuzp
 * @param:
 * @return:
 * @throws:
 * @createdTime: 2019-10-12 10:48
 */
public class Jdk8Test {

    /**
     * @Title:
     * @Description: Lambda表达式
     * 带有参数变量的表达式，是一段可以传递的代码，可以被一次或多次执行
     * 是一种精简的字面写法，其实就是把匿名内部类中“一定”要做的工作省略掉
     * 然后由JVM通过推导把简化的表达式还原
     * 格式：  (parameters参数) -> expression表达式或方法体
     * paramaters：
     * 类似方法中的形参列表，这里的参数是函数式接口里的参数
     * ->：可理解为“被用于”的意思
     * 方法体：
     * 可以是表达式也可以代码块，是函数式接口里方法的实现
     * 如果负责运算的代码无法用表达式表示，可以使用编写方法实现
     * 但必须用{}包围并按需明确使用 return语句
     * @author：com.longshare.liuzp
     * @param:
     * @return:
     * @throws:
     * @createdTime: 2019-10-14 9:36
     */
    public static void main(String[] args) {
        String[] s = {"a","asd","s","sd","dfgh"};
        Jdk8Test t = new Jdk8Test();
      /*  t.outPutString(s);
        for(String str: s) {
            System.out.println(str);
        }*/
      t.createdThread();
    }

    /**
     * Lambda表达式实例1
     * @param str
     */
    private void outPutString(String[] str) {
        //输出字符串
        // 1 传统方式；采用匿名内部类方式
        /*Arrays.sort(str , new Comparator<String>() {
            public int compare(String o1 , String o2) {
                return o1.length() - o2.length();
            }
        });*/

        //2 使用lambda表达式
        Arrays.sort(str,(s1,s2)-> s1.length()-s2.length());
    }

    /**
     * lambda表达式实现多线程
     */
    private void createdThread() {
        /**
         * ()    ->        System.out.println("hello")
         * 参数  表达式标志 表达式或方法体
         */
        new Thread(()-> System.out.println("hello")).start();

        /**
         * 方法体
         */
        new Thread(() -> {
            for(int i=0;i<10;i++) {
                System.out.println(i);
            }
        }).start();
    }
}
