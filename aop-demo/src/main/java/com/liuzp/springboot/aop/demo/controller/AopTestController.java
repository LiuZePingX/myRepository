package com.liuzp.springboot.aop.demo.controller;

import com.liuzp.springboot.aop.demo.annotation.AdminTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:
 * @Description: Aopdemo
 * @author: liuzp
 * @date:   2019/8/19 14:36
 *
 */
@RestController("/aop")
@Slf4j
public class AopTestController {

    @GetMapping
    @AdminTest
    public ResponseEntity<?> getAop() {
        return ResponseEntity.ok("SUCCESS");
    }

    @PostMapping
    public ResponseEntity<?> notGetAop() {
        return ResponseEntity.ok("fail");
    }
}
