package com.amayadream.demo.serviceImpl;

import com.amayadream.demo.dao.IUserDao;
import com.amayadream.demo.pojo.User;
import com.amayadream.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * NAME   :  SSM-demo/com.amayadream.demo.serviceImpl
 * Author :  Amayadream
 * Date   :  2015.11.21 23:20
 * TODO   :
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public List<User> queryAll() {
        return userDao.selectAll();
    }
}
