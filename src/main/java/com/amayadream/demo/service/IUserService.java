package com.amayadream.demo.service;

import com.amayadream.demo.pojo.User;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.service
 * Author :  Amayadream
 * Date   :  2015.12.16 17:24
 * TODO   :
 */
public interface IUserService {
    List<User> selectAll();
    User selectUserById(String username);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String username);
}
