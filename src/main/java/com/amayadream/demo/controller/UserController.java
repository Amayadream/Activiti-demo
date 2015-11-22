package com.amayadream.demo.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.demo.pojo.User;
import com.amayadream.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * NAME   :  SSM-demo/com.amayadream.demo.controller
 * Author :  Amayadream
 * Date   :  2015.11.21 23:18
 * TODO   :
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/all", produces = "application/json;charset:UTF-8")
    @ResponseBody
    public String all(){
        List<User> list = userService.queryAll();
        return JSON.toJSONString(list);
    }
}
