package com.amayadream.demo.service;

import com.amayadream.demo.pojo.Group;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.service
 * Author :  Amayadream
 * Date   :  2015.12.08 15:16
 * TODO   :
 */
public interface IGroupService {
    List<Group> selectAll();
    Group selectGroupById(String id);
    boolean insert(String name, String type);
    boolean update(String id, String name, String type);
    boolean delete(String id);
}
