package com.amayadream.demo.dao;

import com.amayadream.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.dao
 * Author :  Amayadream
 * Date   :  2015.11.30 15:38
 * TODO   :
 */
@Service("userDao")
public interface IUserDao {
    List<User> selectAll();
    User selectUserById(String id);
    boolean insert(User user);
    boolean update(User user);
}
