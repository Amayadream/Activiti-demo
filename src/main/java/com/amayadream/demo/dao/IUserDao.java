package com.amayadream.demo.dao;

import com.amayadream.demo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NAME   :  SSM-demo/com.amayadream.demo.dao
 * Author :  Amayadream
 * Date   :  2015.11.21 23:17
 * TODO   :
 */
@Repository("userDao")
public interface IUserDao {
    public List<User> selectAll();
}
