package com.liuzp.workflowdemo;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class WorkFlowDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkFlowDemoApplication.class , args);
    }

}
