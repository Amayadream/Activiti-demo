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
 * Date   :  2015.12.08 15:21
 * TODO   :
 */
@Service("groupService")
public class GroupServiceImpl implements IGroupService {
    @Resource private IGroupDao groupDao;
    @Resource private Group group;

    public List<Group> selectAll() {
        return groupDao.selectAll();
    }

    public Group selectGroupById(String id) {
        return groupDao.selectGroupById(id);
    }

    public boolean insert(String name, String type) {
        group.setName(name);
        group.setType(type);
        return groupDao.insert(group);
    }

    public boolean update(String id, String name, String type) {
        group.setId(id);
        group.setName(name);
        group.setType(type);
        return groupDao.update(group);
    }

    public boolean delete(String id) {
        return groupDao.delete(id);
    }
}
