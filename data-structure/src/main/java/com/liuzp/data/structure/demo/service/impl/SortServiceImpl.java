package com.liuzp.data.structure.demo.service.impl;

import com.liuzp.data.structure.demo.service.SortService;
import com.liuzp.data.structure.demo.utils.sort.BubbleSort;
import com.liuzp.data.structure.demo.utils.sort.InsertionSort;
import com.liuzp.data.structure.demo.utils.sort.SelectionSort;
import org.springframework.stereotype.Service;


@Service
public class SortServiceImpl implements SortService {
    @Override
    public Double[] bubbleSort(Double[] list) {
        return BubbleSort.bubbleSort(list);
    }

    @Override
    public Double[] selectSort(Double[] list) {
        return SelectionSort.selectSort(list);
    }

    @Override
    public Double[] insertSort(Double[] list) {
        return InsertionSort.insertSort(list);
    }
}
