package com.liuzp.data.structure.demo.service;

import java.util.List;

/**
 * @ClassName:
 * @Description: 排序算法
 * @author: com.longshare.liuzp
 * @date:   2019/7/15 14:42
 *
 */
public interface SortService {

    /**
     * 冒泡排序
     * @param list
     * @return
     */
    Double[] bubbleSort(Double[] list);

    /**
     * 选择排序
     */
    Double[] selectSort(Double[] list);

    /**
     * 插入排序
     */
    Double[] insertSort(Double[] list);
}
