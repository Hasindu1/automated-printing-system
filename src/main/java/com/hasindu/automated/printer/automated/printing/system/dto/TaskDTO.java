/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.dto;

import com.hasindu.automated.printer.automated.printing.system.util.TaskTypes;
import java.util.Objects;

/**
 *
 * @author Hasindu
 */
public class TaskDTO implements Comparable<TaskDTO>{
    private Integer taskId;
    private String taskOwnerFirstName;
    private String taskOwnerLastName;
    private Integer noOfPages;
    private TaskTypes taskType;
    private Integer completedAmount;

    public TaskDTO() {
        taskType = TaskTypes.WAIT;
    }

    public TaskDTO(Integer taskId, String taskOwnerFirstName, String taskOwnerLastName, Integer noOfPages, TaskTypes taskType) {
        this.taskId = taskId;
        this.taskOwnerFirstName = taskOwnerFirstName;
        this.taskOwnerLastName = taskOwnerLastName;
        this.noOfPages = noOfPages;
        this.taskType = taskType;
    }
    
    
    

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskOwnerFirstName() {
        return taskOwnerFirstName;
    }

    public void setTaskOwnerFirstName(String taskOwnerFirstName) {
        this.taskOwnerFirstName = taskOwnerFirstName;
    }

    public String getTaskOwnerLastName() {
        return taskOwnerLastName;
    }

    public void setTaskOwnerLastName(String taskOwnerLastName) {
        this.taskOwnerLastName = taskOwnerLastName;
    }

    public Integer getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(Integer noOfPages) {
        this.noOfPages = noOfPages;
    }

    public TaskTypes getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskTypes taskType) {
        this.taskType = taskType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.taskId);
        return hash;
    }

    public Integer getCompletedAmount() {
        return completedAmount;
    }

    public void setCompletedAmount(Integer completedAmount) {
        this.completedAmount = completedAmount;
    }
    @Override
    public int compareTo(TaskDTO taskDTO) {
        if(this.getTaskId().intValue()==taskDTO.getTaskId().intValue())
            return 0;
        else if(this.getTaskId().intValue()>taskDTO.getTaskId().intValue())
            return 1;
        else
            return 0;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaskDTO other = (TaskDTO) obj;
        if (!Objects.equals(this.taskId, other.taskId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TaskDTO{" + "taskId=" + taskId + ", taskOwnerFirstName=" + taskOwnerFirstName + ", taskOwnerLastName=" + taskOwnerLastName + ", noOfPages=" + noOfPages + ", taskType=" + taskType + ", completedAmount=" + completedAmount + '}';
    }

    


    

    
    
    
    
    
}
