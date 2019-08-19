package com.liuzp.data.structure.demo.utils.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:
 * @Description: 选择排序，时间复杂度（O（N*N/2））
 * @author: com.longshare.liuzp
 * @date:   2019/7/17 15:02
 *
 */
@Slf4j
public class SelectionSort {

    /**
     * @Title:
     * @Description: 从起始位置开始，逐个遍历获取最小值，与当前遍历周期的起始的位置交换，
     *                 当遍历到倒数第二位或者没有发生位置交换时结束
     * @author：com.longshare.liuzp
     * @param:
     * @return:
     * @throws:
     * @createdTime: 2019/7/17 15:09
     */
    public static Double[] selectSort(Double[] arr) {
        log.debug("进入选择排序");
        // i 记录遍历周期与起始位置
        for (int i = 0; i < arr.length-1; i++) {
            Map<Integer,Double> map = new HashMap<>();
            double min = arr[i]; // 记录最小值
            map.put(i,min);
            for (int j = i+1;j<arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    map.clear();
                    map.put(j,min);
                }
            }
            // 交换位置
            if(!(map.keySet().iterator().next() == i)) {
                double temp = arr[i];
                arr[i] = min;
                arr[map.keySet().iterator().next()] = temp;
            }
        }
        return arr;
    }
}
