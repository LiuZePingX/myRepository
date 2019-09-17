package com.liuzp.workflowdemo.model.param;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskReviewParam {

    private String username;
    private String taskId;
}
