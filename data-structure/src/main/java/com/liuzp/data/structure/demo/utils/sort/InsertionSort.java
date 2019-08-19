package com.liuzp.data.structure.demo.utils.sort;

/**
 * @ClassName:
 * @Description: 插入排序：从索引 1 开始，将索引 1 处的数据取出放到临时变量中去，比较其左边的数据，
 * 若比临时变量大，则将其平移到索引 空隙的位置，重复指导数组有序，最后将临时变量中的值插入到当前的空隙处。
 * 时间复杂度：O（N*N+2N-2）
 * @author: com.longshare.liuzp
 * @date: 2019/7/22 10:54
 */
public class InsertionSort {

    public static Double[] insertSort(Double[] arr) {
        // 选择索引为1的位置，存入临时变量
        if (arr.length <= 1) {
            return arr;
        }
        double temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int index = -1;
            for (int j = i - 1; j > -1; j--) {
                if (arr[j] > temp) {
                    index = j;
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            if (index != -1) {
                arr[index] = temp;
            }
        }

        return arr;
    }
}
