package com.liuzp.jdk.jdk8;

import java.util.ArrayList;
import java.util.List;

/**
 * 并行API
 * liuzp
 *
 * 在Java7之前，并行处理数据基本是通过多线程来解决
 *
 * a.将数据分成部分
 *
 * b.给每个子部分分配一个子线程
 *
 * c.等待所有的子线程全部结束
 *
 * d.合并子线程
 *
 * 这样的并行数据处理不稳定、易出错，在Java8中Stream接口应用分支/合并框架
 *
 * 将一个数据内容分成多个数据块，并用不同的线程分别处理每个数据块流
 *
 * Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成
 *
 * 而并行Stream则是在多个线程上同时执行
 *
 */
public class ParallelAPI {

    /**
     * 使用方法：
     * 通常编写并行代码很难而且容易出错,
     *
     * 但使用 Stream API 无需编写一行多线程的代码
     *
     * 就可以很方便地写出高性能的并发程序 
     *
     * a.调用Stream的parallel()方法
     *
     * b.调用Collection的parallelStream()方法
     *
     * c.parallel() 与 sequential() 可在并行流与顺序流之间切换
     *
     * 建议
     * a.尽量使用基本类型的流  IntStream, LongStream, and DoubleStream
     *
     * b.有些操作使用并发流的性能会比顺序流的性能更差，比如limit，findFirst，依赖元素顺序的操作在并发流中是极其消耗性能的.findAny的性能就会好很多，因为不依赖顺序
     *
     * c.考虑流中计算的性能(Q)和操作的性能(N)的对比， Q表示单个处理所需的时间， N表示需要处理的数量，如果Q的值越大, 使用并发流的性能就会越高
     *
     * d.数据量不大时使用并发流，性能得不到提升
     *
     * e.考虑数据结构：并发流需要对数据进行分解，不同的数据结构被分解的性能是不一样的
     *
     * f.传递给并行流的函数都是线程安全的，无副作用
     *
     * 当任务涉及到I/O操作并且任务之间不互相依赖时，那么适合并行化
     */
    public static void main(String[] args) {
        new ParallelAPI().test1();
    }

    private void test1() {
        // 求和
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=100;i++) {
         list.add(i);
        }

        // 使用stream的parallel()方法
        // reduce 参数1：和的初始值
        Integer total = list.stream().parallel().reduce(0,(r,l)-> r+l);
        System.out.println(total);
    }

}
