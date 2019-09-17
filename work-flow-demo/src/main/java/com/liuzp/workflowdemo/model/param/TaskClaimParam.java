package com.liuzp.workflowdemo.model.param;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskClaimParam {
    private String username;
    private String processInstanceId;
}
