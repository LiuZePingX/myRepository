package com.liuzp.data.structure.demo.controller;

import com.liuzp.data.structure.demo.orm.BinarySearchParam;
import com.liuzp.data.structure.demo.service.SearchService;
import com.liuzp.data.structure.demo.service.SortService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/v1/test")
@Slf4j
public class TestController {

    @Resource
    SearchService searchService;
    @Resource
    SortService sortService;

    @PostMapping
    public ResponseEntity<?> search(@RequestBody BinarySearchParam param) {
        log.debug("进入二分查找接口");
        Integer index = searchService.binarySearch(param.getSrotArr() , param.getTarget() , new Integer(0) , param.getSrotArr().length - 1);
        if (!(index == -1)) {
            return ResponseEntity.ok(param.getSrotArr()[index]);
        }
        return ResponseEntity.ok("fail");
    }

    @PatchMapping
    public ResponseEntity<?> sort(@RequestBody(required = false) List<Double> list) {

        log.debug("进入排序接口");
        Double[] noSort = {9.0 , 8.0 , 7.0 , 6.0 , 4.0 , 3.0 , 2.0 , 1.0};
        return ResponseEntity.ok(sortService.bubbleSort(noSort));
    }

    @GetMapping
    public ResponseEntity<?> selectSort() {
        log.debug("进入选择排序");
        Double[] noSort = {9.0 , 8.0 , 7.0 , 6.0 , 4.0 , 3.0 , 2.0 , 1.0};
        return ResponseEntity.ok(sortService.selectSort(noSort));
    }

    @DeleteMapping
    public ResponseEntity<?> insertSort() {
        log.debug("进入选择排序");
        Double[] noSort = {9.0 , 8.0 , 7.0 , 6.0 , 4.0 , 3.0 , 2.0 , 1.0};
        return ResponseEntity.ok(sortService.insertSort(noSort));
    }

}
