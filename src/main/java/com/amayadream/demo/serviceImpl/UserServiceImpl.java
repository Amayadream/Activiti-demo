package com.amayadream.demo.serviceImpl;

import com.amayadream.demo.dao.IUserDao;
import com.amayadream.demo.pojo.User;
import com.amayadream.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.serviceImpl
 * Author :  Amayadream
 * Date   :  2015.11.30 15:39
 * TODO   :
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    public List<User> selectAll() {
        return userDao.selectAll();
    }

    public User selectUserById(String id) {
        return userDao.selectUserById(id);
    }

    public boolean insert(User user) {
        return userDao.insert(user);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }
}
