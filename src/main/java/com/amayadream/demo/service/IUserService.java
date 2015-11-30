package com.amayadream.demo.service;

import com.amayadream.demo.pojo.User;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.service
 * Author :  Amayadream
 * Date   :  2015.11.30 15:38
 * TODO   :
 */
public interface IUserService {
    List<User> selectAll();
    User selectUserById(String id);
    boolean insert(User user);
    boolean update(User user);
}
