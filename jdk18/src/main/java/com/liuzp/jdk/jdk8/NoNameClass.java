package com.liuzp.jdk.jdk8;

/**
 * 匿名内部类
 * 匿名内部类并不会把真正的名字显示出来，在父类初始化的时候已经被实例化了，继承父类的方法直接覆盖
 */
public class NoNameClass {
    //匿名内部类z
    AbstructClass a = new AbstructClass() {
        @Override
        public void say() {
            System.out.println("这是匿名内部类");
        }
    };
}
