package com.amayadream.demo.service;

import com.amayadream.demo.pojo.Group;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.service
 * Author :  Amayadream
 * Date   :  2015.11.30 15:38
 * TODO   :
 */

public interface IGroupService {
    List<Group> selectAll();
    Group selectGroupById(String id);
    boolean insert(Group group);
    boolean update(Group group);
}
