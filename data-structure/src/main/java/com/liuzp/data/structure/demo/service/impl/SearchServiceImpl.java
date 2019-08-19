package com.liuzp.data.structure.demo.service.impl;

import com.liuzp.data.structure.demo.service.SearchService;
import com.liuzp.data.structure.demo.utils.search.BinarySearch;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public Integer binarySearch(double[] sortArr , double target , Integer start , Integer end) {
        return BinarySearch.binarySearch(sortArr , target , start , end);
    }
}
