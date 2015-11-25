package com.amayadream.demo;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.io.FileInputStream;
import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo
 * Author :  Amayadream
 * Date   :  2015.11.25 20:36
 * TODO   :
 */
public class test {
    // diagrams实际路径
    private static String realPath = "D:\\workspace\\idea_workspace\\Activiti-demo\\src\\main\\resources\\diagrams";
    public static void main(String[] args) throws Exception {
        // 创建 Activiti流程引擎
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml")
                .buildProcessEngine();

        // 取得 Activiti 服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 部署流程定义
        repositoryService
                .createDeployment()
                .addInputStream("DemoProcess.bpmn",new FileInputStream(realPath + "\\DemoProcess.bpmn"))
                .addInputStream("DemoProcess.png", new FileInputStream(realPath + "\\DemoProcess.png"))
        .deploy();

        // 启动流程实例
        ProcessInstance instance = processEngine
                .getRuntimeService().startProcessInstanceByKey("DemoProcess");
        String procId = instance.getId();
        System.out.println("procId:"+ procId);

        // 获得第一个任务
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskDefinitionKey("firstTask").list();
        for (Task task : tasks) {
            System.out.println("Following task is: taskID -" +task.getId()+" taskName -"+ task.getName());
            // 认领任务
            taskService.claim(task.getId(), "testUser");
        }

        // 查看testUser 现在是否能够获取到该任务
        tasks = taskService.createTaskQuery().taskAssignee("testUser").list();
        for (Task task : tasks) {
            System.out.println("Task for testUser: " + task.getName());
            // 完成任务
            taskService.complete(task.getId());
        }
        System.out.println("Number of tasks for testUser: "
                + taskService.createTaskQuery().taskAssignee("testUser").count());


        // 获取并认领第二个任务
        tasks = taskService.createTaskQuery().taskDefinitionKey("secondTask").list();
        for (Task task : tasks) {
            System.out.println("Following task is : taskID -" +task.getId()+" taskName -"+ task.getName());
            taskService.claim(task.getId(), "testUser");
        }

        //完成第二个任务结束结束流程
        for (Task task : tasks) {
            taskService.complete(task.getId());
        }

        // 核实流程是否结束
        HistoryService historyService = processEngine.getHistoryService();
        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(procId).singleResult();
        System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());
    }
}
