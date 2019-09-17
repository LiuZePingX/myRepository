package com.liuzp.data.structure.demo.utils.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName:
 * @Description: 快速排序：
 * 分区：1 选轴，左指针，右指针
 *      2 右移左指针，当遇到大于或者等于轴时停下指针
 *      3 左移右指针，当遇到小于等于轴时停下，交换左右指针位置数据
 *      4 重复1,2,3直到左右指针重合或者左指针在右指针右边时，交换轴与左指针位置，
 *      执行上述步骤后，轴已经在正确的位置上，此时只需要调用递归，将轴左右的数组继续进行分区，直到分区形成的数组长度为0或者1时结束递归
 *
 *      异常：StackOverflowError  栈溢出，调用栈太过深入而无法停止（死循环）
 * @author: com.longshare.liuzp
 * @date:   2019/9/2 13:43
 *
 */
@Slf4j
public class QuickSort {

    public void quickSort(Double[] targetArr, int startIndex, int endIndex) {
        log.debug("进入快速排序", targetArr);
        // 当数组长度为0或者1时结束
        int length = endIndex - startIndex;
        if(length > 0) {
            int leftPoint = startIndex; // 左指针
            int rightPoint = endIndex-1; // 右指针
            double axis = targetArr[endIndex];; // 轴
            boolean leftFlag = true; // 左指针移动标志
            boolean rightFlag = true; // 右指针移动标志
            boolean isContinue = true;
            // 左指针
            while (isContinue) {
                while (leftFlag) {
                    if(targetArr[leftPoint]<axis) {
                        leftPoint++;
                    }else {
                        leftFlag = false;
                    }
                }
                // 右指针
                while (rightFlag) {
                    if(targetArr[rightPoint]>axis) {
                        rightPoint--;
                    }else {
                        rightFlag = false;
                    }
                }
                // 判断左右指针位置是否重合，或左指针是否在右指针右边
                if(leftPoint >= rightPoint) {
                    // 将轴与左指针交换位置
                    double temp = targetArr[leftPoint];
                    targetArr[leftPoint] = axis;
                    targetArr[endIndex] = temp;
                    isContinue = false;
                }else {
                    // 交换左右指针值
                    double temp  = targetArr[leftPoint];
                    targetArr[leftPoint] = targetArr[rightPoint];
                    targetArr[rightPoint] = temp;
                    leftFlag = true;
                    rightFlag = true;
                }
            }

            //quickSort(targetArr, 0,leftPoint-1);
            quickSort(targetArr,leftPoint+1,targetArr.length-1);

        }else {
            System.out.println("退出排序");
            return ;
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Double[] targetArr = {0.0,3.0,2.0,1.0,9.0,5.0,6.0};
        System.out.println("快速排序前："+ targetArr.toString());
        quickSort.quickSort(targetArr,0,targetArr.length-1);
        System.out.println("快速排序后："+ targetArr.toString());
    }
}
