package com.liuzp.workflowdemo.controller;

import com.liuzp.workflowdemo.model.param.TaskClaimParam;
import com.liuzp.workflowdemo.model.param.TaskReviewParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.task.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 任务列表
 */
@Controller
@RequestMapping("/task")
@Slf4j
public class TaskListController {

    @Resource
    TaskService taskService;
    @Resource
    IdentityService identityService;
    @Resource
    HistoryService historyService;

    /**
     * 查询自身任务列表
     */
    @GetMapping("/self-list")
    public ResponseEntity<?> getSelfList(@RequestParam("assignee") String assignee) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
        if (tasks != null && !tasks.isEmpty()) {
            List<Map<String, Object>> resultList = new ArrayList<>(tasks.size());
            buildTasks(tasks,resultList);
            return ResponseEntity.ok(resultList);
        } else {
            return ResponseEntity.ok("fail");
        }
    }

    /**
     * 可用任务列表
     */
    @GetMapping("/available/tasks")
    public ResponseEntity<?> availableTaskList(@RequestParam("username") String username) {
        //1、根据用户名查询所在组
        List<org.camunda.bpm.engine.identity.Group> list = identityService.createGroupQuery().groupMember(username).list();
        if (list != null && !list.isEmpty()) {
            //2、获取所有组名
            //这里我配置错了，错把id当name了。
            List<String> collect = list.stream().map(Group::getId).collect(Collectors.toList());
            //3、根据组名查询所有任务
            List<Task> tasks = taskService.createTaskQuery().taskCandidateGroupIn(collect).list();
            if (tasks != null && !tasks.isEmpty()) {
                List<Map<String, Object>> resultList = new ArrayList<>(tasks.size());
                buildTasks(tasks,resultList);
                return ResponseEntity.ok(resultList);
            } else {
                return ResponseEntity.ok(null);
            }
        } else {
            return ResponseEntity.ok(null);
        }
    }

    private void buildTasks(List<Task> tasks, List<Map<String, Object>> resultList) {
        tasks.forEach(task -> {
            Map<String, Object> map = new HashMap<>(3);
            map.put("processDefinitionId" , task.getProcessDefinitionId());
            map.put("processInstanceId" , task.getProcessInstanceId());
            map.put("taskId" , task.getId());
            resultList.add(map);
        });
    }

    /**
     * 任务领取
     */
    @PostMapping("/claim/task")
    public ResponseEntity<String> claimTask(@Valid @RequestBody TaskClaimParam param) {
        //1、查询组名
        List<Group> list = identityService.createGroupQuery().groupMember(param.getUsername()).list();
        if (list != null && !list.isEmpty()) {
            List<String> collect = list.stream().map(Group::getId).collect(Collectors.toList());
            //2、查询任务
            Task task = taskService.createTaskQuery().taskCandidateGroupIn(collect).processInstanceId(param.getProcessInstanceId()).singleResult();
            if (task != null) {
                //3、判断该任务是否被领取
                if (StringUtils.isBlank(task.getAssignee())) {
                    taskService.claim(task.getId(), param.getUsername());
                    return ResponseEntity.ok(task.getAssignee());
                } else {
                   return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 任务审核
     */
    @PostMapping("/review/task")
    public ResponseEntity<String> review(@Valid @RequestBody TaskReviewParam param) {
        //1、查询任务
        Task task = taskService.createTaskQuery().taskId(param.getTaskId()).taskAssignee(param.getUsername()).singleResult();
        if (task != null) {
            taskService.complete(param.getTaskId());
            return ResponseEntity.ok("任务审核成功");
        } else {
            return null;
        }
    }

    /**
     * 流程历史记录
     */
    @GetMapping("/histories")
    public ResponseEntity<?> processHistories(@RequestParam("processInstanceId") String processInstanceId) {
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();
        if (list != null && !list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return null;
        }
    }
}
