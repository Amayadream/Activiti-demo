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
 * Date   :  2015.12.08 14:51
 * TODO   :
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource private IUserDao userDao;
    @Resource private User user;

    public List<User> selectAll() {
        return userDao.selectAll();
    }

    public User selectUserById(String id) {
        return userDao.selectUserById(id);
    }

    public boolean insert(String email, String first, String last, String password) {
        user.setEmail(email);
        user.setFirst(first);
        user.setLast(last);
        user.setPassword(password);
        return userDao.insert(user);
    }

    public boolean update(String id, String email, String first, String last, String password) {
        user.setId(id);
        user.setEmail(email);
        user.setFirst(first);
        user.setLast(last);
        user.setPassword(password);
        return userDao.update(user);
    }

    public boolean delete(String id) {
        return userDao.delete(id);
    }
}
