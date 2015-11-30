package com.amayadream.demo.serviceImpl;

import com.amayadream.demo.dao.IGroupDao;
import com.amayadream.demo.pojo.Group;
import com.amayadream.demo.service.IGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.serviceImpl
 * Author :  Amayadream
 * Date   :  2015.11.30 15:39
 * TODO   :
 */
@Service("groupService")
public class GroupServiceImpl implements IGroupService {
    @Resource
    private IGroupDao groupDao;

    public List<Group> selectAll() {
        return groupDao.selectAll();
    }

    public Group selectGroupById(String id) {
        return groupDao.selectGroupById(id);
    }

    public boolean insert(Group group) {
        return groupDao.insert(group);
    }

    public boolean update(Group group) {
        return groupDao.update(group);
    }
}
