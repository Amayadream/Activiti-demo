package com.amayadream.demo.activiti.leave;

import com.amayadream.demo.dao.ILeaveDao;
import com.amayadream.demo.pojo.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.activiti.leave
 * Author :  Amayadream
 * Date   :  2015.11.26 14:33
 * TODO   :  请假实体管理
 */
@Component
@Transactional(readOnly = true)
public class LeaveManager {
    private ILeaveDao.LeaveDao leaveDao;

    public Leave getLeave(Long id) {
        return leaveDao.findOne(id);
    }

    @Transactional(readOnly = false)
    public void saveLeave(Leave entity) {
        if (entity.getId() == null) {
            entity.setApplyTime(new Date());
        }
        leaveDao.save(entity);
    }

    @Autowired
    public void setLeaveDao(ILeaveDao.LeaveDao leaveDao) {
        this.leaveDao = leaveDao;
    }
}
