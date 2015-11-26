package com.amayadream.demo.activiti.leave;

import com.amayadream.demo.pojo.Leave;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.activiti.leave
 * Author :  Amayadream
 * Date   :  2015.11.26 14:48
 * TODO   :  销假后处理器
 */

@Component
@Transactional
public class ReportBackEndProcessor {
    private static final long serialVersionUID = 1L;

    @Autowired
    LeaveManager leaveManager;

    @Autowired
    RuntimeService runtimeService;

    /* (non-Javadoc)
     * @see org.activiti.engine.delegate.TaskListener#notify(org.activiti.engine.delegate.DelegateTask)
     */
    public void notify(DelegateTask delegateTask) {
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        Leave leave = leaveManager.getLeave(new Long(processInstance.getBusinessKey()));
        Object realityStartTime = delegateTask.getVariable("realityStartTime");
        leave.setRealityStartTime((String) realityStartTime);
        Object realityEndTime = delegateTask.getVariable("realityEndTime");
        leave.setRealityEndTime((String) realityEndTime);

        leaveManager.saveLeave(leave);
    }
}
