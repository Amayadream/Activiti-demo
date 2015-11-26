package com.amayadream.demo.pojo;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.pojo
 * Author :  Amayadream
 * Date   :  2015.11.26 10:34
 * TODO   :  Leave表的实体类
 */
@Repository("leave")
public class Leave {
    /**
     * 编号
     */
    private int id;

    /**
     * 流程编号
     */
    private String processInstanceId;

    /**
     * 工号
     */
    private String userId;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 假种
     */
    private String leaveType;

    /**
     * 请假事由
     */
    private String reason;

    /**
     * 申请时间
     */
    private String applyTime;

    /**
     * 实际开始时间
     */
    private String realityStartTime;

    /**
     * 实际结束时间
     */
    private String realityEndTime;


    //-- 临时属性开始 --//

    /**
     * 流程任务
     */
    private Task task;

    private Map<String, Object> variables;

    /**
     * 运行中的流程实例
     */
    private ProcessInstance processInstance;

    /**
     * 历史的流程实例
     */
    private HistoricProcessInstance historicProcessInstance;

    /**
     * 流程定义
     */
    private ProcessDefinition processDefinition;

    //-- 临时属性结束 --//

    /**
     * getter&setter
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getRealityStartTime() {
        return realityStartTime;
    }

    public void setRealityStartTime(String realityStartTime) {
        this.realityStartTime = realityStartTime;
    }

    public String getRealityEndTime() {
        return realityEndTime;
    }

    public void setRealityEndTime(String realityEndTime) {
        this.realityEndTime = realityEndTime;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public HistoricProcessInstance getHistoricProcessInstance() {
        return historicProcessInstance;
    }

    public void setHistoricProcessInstance(HistoricProcessInstance historicProcessInstance) {
        this.historicProcessInstance = historicProcessInstance;
    }

    public ProcessDefinition getProcessDefinition() {
        return processDefinition;
    }

    public void setProcessDefinition(ProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }
}
