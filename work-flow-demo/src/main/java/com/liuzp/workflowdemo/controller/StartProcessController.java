package com.liuzp.workflowdemo.controller;

import com.liuzp.workflowdemo.model.param.ProcessStartParam;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 流程发起
 */
@Controller
@RequestMapping("/start/process")
@Slf4j
public class StartProcessController {

    @Resource
    RuntimeService runtimeService;

    @PostMapping
    public ResponseEntity<?> start(@Valid @RequestBody ProcessStartParam param) {
        log.info("发起流程");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(param.getProcessDefinitionId());
        Map<String, Object> map = new HashMap<>();
        map.put("processDefinitionId", processInstance.getProcessDefinitionId());
        map.put("processInstanceId", processInstance.getProcessInstanceId());
        map.put("businessKey", processInstance.getBusinessKey());
        map.put("caseInstanceId", processInstance.getCaseInstanceId());
        map.put("rootProcessInstanceId", processInstance.getRootProcessInstanceId());
        log.info("流程发起成功{}");
        return ResponseEntity.ok(map);
    }
}
