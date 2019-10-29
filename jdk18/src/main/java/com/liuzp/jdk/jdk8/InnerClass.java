package com.liuzp.jdk.jdk8;

/**
 * liuzp
 *内部类实例
 */
public class InnerClass {
    public static void main(String[] args) {
        A a = new A();
        A.B b = new A().new B();
        System.out.println(b.getB());
        System.out.println("***********************************************************");
        AbstructClass abstructClass = new AbstructClass() {
            @Override
            public void say() {
                System.out.println("这是匿名内部类");
            }
        };
        abstructClass.say();
    }

}

/**
 * 内部类
 */
class A {
    private Integer a = 10;

    public Integer getA() {
        System.out.println("这是外部类，获取外部类属性");
        return this.a;
    }

    class B {
        private Integer b=2;
        public Integer getB() {
            System.out.println("这是内部类");
            System.out.println(a+b);
            return getA();
        }
    }
}
