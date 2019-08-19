package com.liuzp.data.structure.demo.utils.algorithm;

/**
 * @ClassName:
 * @Description: 递归算法，函数自己调用自己，无线递归相当于死循环，
 * @author: com.longshare.liuzp
 * @date:   2019/7/23 9:38
 *
 */
public class RecursionAlgorithm {

    public static void recursion(int i) {
        if(i>-1) {
            System.out.println(i);
            i--;
            recursion(i);
        }
    }

    public static void main(String[] args) {
        recursion(new Integer(10));
    }
}
