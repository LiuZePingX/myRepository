package com.liuzp.data.structure.demo.service;

/**
 * @ClassName:
 * @Description: 查找算法service
 * @author: com.longshare.liuzp
 * @date: 2019/7/15 11:00
 */
public interface SearchService {

    /**
     * 二分查找
     *
     * @param sortArr
     * @param target
     * @param start
     * @param end
     * @return
     */
    Integer binarySearch(double[] sortArr , double target , Integer start , Integer end);
}
