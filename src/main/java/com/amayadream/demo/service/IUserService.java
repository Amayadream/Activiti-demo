package com.amayadream.demo.service;

import com.amayadream.demo.pojo.User;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.service
 * Author :  Amayadream
 * Date   :  2015.12.08 14:51
 * TODO   :
 */
public interface IUserService {
    List<User> selectAll();
    User selectUserById(String id);
    boolean insert(String email, String first, String last, String password);
    boolean update(String id, String email, String first, String last, String password);
    boolean delete(String id);
}
