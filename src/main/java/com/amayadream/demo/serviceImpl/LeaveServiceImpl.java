package com.amayadream.demo.serviceImpl;

import com.amayadream.demo.dao.ILeaveDao;
import com.amayadream.demo.pojo.Leave;
import com.amayadream.demo.service.ILeaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.serviceImpl
 * Author :  Amayadream
 * Date   :  2015.11.30 15:26
 * TODO   :
 */
@Service("leaveService")
public class LeaveServiceImpl implements ILeaveService {
    @Resource
    private ILeaveDao leaveDao;

    public List<Leave> selectAll() {
        return leaveDao.selectAll();
    }

    public Leave selectLeaveById(String id) {
        return leaveDao.selectLeaveById(id);
    }

    public boolean insert(Leave leave) {
        return leaveDao.insert(leave);
    }

    public boolean update(Leave leave) {
        return leaveDao.update(leave);
    }
}
