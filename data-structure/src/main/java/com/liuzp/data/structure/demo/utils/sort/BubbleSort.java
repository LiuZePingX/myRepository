package com.liuzp.data.structure.demo.utils.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName:
 * @Description: 冒泡排序：时间复杂度O(N*N)
 * @author: com.longshare.liuzp
 * @date:   2019/7/15 14:23
 *
 */
@Slf4j
public class BubbleSort {

    public static Double[] bubbleSort(Double[] list) {
        log.debug("进入冒泡排序");
        if(list.length==0) {
            return null;
        }
        Boolean flag = false;// 结束标志，未发生交换则置为true
        Integer length = list.length-1;// 每次轮完一轮时，由于最大值已经冒泡到正确位置，所以下一轮的循环长度需要减一
        Integer count = 0;
        while(!flag) {
            log.debug(String.valueOf(++count));
            flag = true; //当发生位置交换时，flag = false
            for(int i=0;i<length;i++) {
                if(list[i]>list[i+1]) {
                    flag = false;
                    Double temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                }

            }
            length--;
        }

        return list;
    }
}
