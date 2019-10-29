package com.liuzp.jdk.jdk8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流 对集合进行并行处理
 *
 * 是用函数式编程方式在集合类上进行复杂操作的工具，更像一个高级版本的 Iterator
 *
 * 原始版本的 Iterator，用户只能显式地一个一个遍历元素并对其执行某些操作
 *
 * 高级版本的 Stream，用户只要给出需要对其包含的元素执行什么操作
 *
 * Stream 会隐式地在内部进行遍历，做出相应的数据转换
 *
 * 而和迭代器又不同的是，Stream 可以并行化操作
 *
 * 借助于 Lambda 表达式，极大的提高编程效率和程序可读性
 *
 * Ctrl+Alt+O 清除垃圾引用
 *
 * // 将符合要求的放入集合
 * 		List<String> list2 = list.stream().filter((s) -> s.length() > 2).collect(Collectors.toList());
 *
 * 	1 将集合转成stream，执行过滤filter 过滤条件 (s) -> s.length() > 2
 * 	2 将过滤出来的数据转成一个新的集合 collect(Collectors.toList())
 *
 *
 * 	map:
 * 	如果有一个函数可以将一种类型的值转换成另外一种类型
 *  map 操作就可以使用该函数，将一个流中的值转换成一个新的流
 *
 * 转换为大写
 * 	List<String> list2 = list.stream().map((s) -> s.toUpperCase()).collect(Collectors.toList());
 *
 *
 * 	filter
 * 	遍历数据并检查其中的元素。例如获取字符串List中以数字开始的字符集合
 * 	// 获取数字开头的
 * 	List<String> list2 = list.stream().filter((s) -> Character.isDigit(s.charAt(0))).collect(Collectors.toList());
 *
 *
 * 	使用指定的字符串连接多个字符
 * 	String join = String.join("-", str);
 */
public class StreamUtil {

    public static void main(String[] args) {
//        String[] s = {"1","2","3"};
//
//        String jion = String.join("/",s);
//        System.out.println(jion);

        /**
         * a.获取Student集合中年龄小于20岁的集合中年龄最大的学生信息
         *
         * Student类省略
         */
       /* List<Student> students = new ArrayList<>();
        students.add(new StreamUtil().new Student("张山",23));
        students.add(new StreamUtil().new Student("李四",19));
        students.add(new StreamUtil().new Student("wangwu",18));
        students.add(new StreamUtil().new Student("mazi",20));

        Student student = students.stream().filter((s)-> s.getAge() <20).max(Comparator.comparing((s)->s.getAge())).get();
        System.out.print(student.toString());*/

        /**
         * 查找集合中以a开头的字符的长度集合
         */
        List<Integer> list = Stream.of("a","affff","fff","vgg","argrgrg").filter((s)-> s.startsWith("a")).map((s)-> s.length()).collect(Collectors.toList());
        list.forEach(
                System.out::println
        );

    }

    class Student {
        private String name;
        private Integer age;

        public Student(String name,Integer age) {
            this.age = age;
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public Integer getAge() {
            return this.age;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public String toString() {
            return "age:"+this.age +"\n"+"name:"+this.name;
        }
    }

}
