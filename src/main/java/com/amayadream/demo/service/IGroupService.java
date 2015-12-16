package com.amayadream.demo.service;

import com.amayadream.demo.pojo.Group;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.service
 * Author :  Amayadream
 * Date   :  2015.12.16 17:24
 * TODO   :
 */
public interface IGroupService {
    List<Group> selectAll();
    List<Group> selectGroupByUsername(String username);
    Group selectGroupById(String id);
    boolean insert(Group group);
    boolean update(Group group);
    boolean delete(String id);
}
