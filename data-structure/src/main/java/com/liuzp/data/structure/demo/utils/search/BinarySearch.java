package com.liuzp.data.structure.demo.utils.search;

/**
 * @param sortArr 有序数组
 * @param target  目标数据
 * @param start   数组起始位置
 * @param end     数组结束位置
 * @ClassName:
 * @Description: 二分查找法：折半查找
 * @return index   目标数据在有序数组中的索引
 * @author: com.longshare.liuzp
 * @date: 2019/7/15 10:23
 */
public class BinarySearch {

    /**
     * @Title:
     * @Description: 二分查找（折半查找）
     * @author：com.longshare.liuzp
     * @param:
     * @return:
     * @throws:
     * @createdTime: 2019/7/15 10:29
     */
    public static Integer binarySearch(double[] sortArr , double target , Integer start , Integer end) {

        // 数组越界
        if (start >= sortArr.length || end >= sortArr.length) {
            return -1;
        }
        if (sortArr.length == 0) {
            // 数组为空返回-1
            return -1;
        }
        if (end - start == 1) {
            if (target == sortArr[start]) {
                return start;
            }
            if (target == sortArr[end]) {
                return end;
            }
            return -1;
        }

        // 中间位置
        int middle;
        if (start == 0) {
            middle = end / 2;
        } else {
            middle = (end + start) / 2;
        }
        if (target == sortArr[middle]) {
            return middle;
        }
        // 小于取左边区域
        if (target < sortArr[middle]) {
            end = middle - 1;
            binarySearch(sortArr , target , start , end);

        } else {
            // 大于取右
            start = middle + 1;
            return binarySearch(sortArr , target , start , end);
        }
        return -1;
    }
}
