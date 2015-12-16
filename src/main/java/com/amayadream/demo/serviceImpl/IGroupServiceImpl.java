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
 * Date   :  2015.12.16 17:27
 * TODO   :
 */
@Service("groupService")
public class IGroupServiceImpl implements IGroupService {
    @Resource
    private IGroupDao groupDao;

    public List<Group> selectAll() {
        return groupDao.selectAll();
    }

    public List<Group> selectGroupByUsername(String username) {
        return groupDao.selectGroupByUsername(username);
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

    public boolean delete(String id) {
        return groupDao.delete(id);
    }
}
