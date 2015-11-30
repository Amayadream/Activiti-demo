package com.amayadream.demo.pojo;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.dao
 * Author :  Amayadream
 * Date   :  2015.11.30 15:15
 * TODO   :
 */
@Repository("leave")
public class Leave {
    private String id;                  //ID,sys_guid()自动生成
    private String processinstanceid;   //流程ID
    private String userid;              //工号
    private String starttime;           //开始时间
    private String endtime;             //结束时间
    private String leavetype;           //假种
    private String reason;              //请假事由
    private String applytime;           //申请时间
    private String realitystarttime;    //实际开始时间
    private String realityendtime;      //实际结束时间

    // 流程任务
    private Task task;

    private Map<String, Object> variables;

    // 运行中的流程实例
    private ProcessInstance processInstance;

    // 历史的流程实例
    private HistoricProcessInstance historicProcessInstance;

    // 流程定义
    private ProcessDefinition processDefinition;

    /**
     * getter&setter
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessinstanceid() {
        return processinstanceid;
    }

    public void setProcessinstanceid(String processinstanceid) {
        this.processinstanceid = processinstanceid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public String getRealitystarttime() {
        return realitystarttime;
    }

    public void setRealitystarttime(String realitystarttime) {
        this.realitystarttime = realitystarttime;
    }

    public String getRealityendtime() {
        return realityendtime;
    }

    public void setRealityendtime(String realityendtime) {
        this.realityendtime = realityendtime;
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
