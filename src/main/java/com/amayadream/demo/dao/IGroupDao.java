package com.amayadream.demo.dao;

import com.amayadream.demo.pojo.Group;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.dao
 * Author :  Amayadream
 * Date   :  2015.11.30 15:38
 * TODO   :
 */
@Service("groupDao")
public interface IGroupDao {
    List<Group> selectAll();
    Group selectGroupById(String id);
    boolean insert(Group group);
    boolean update(Group group);
}
