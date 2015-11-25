package com.amayadream.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.controller
 * Author :  Amayadream
 * Date   :  2015.11.25 13:59
 * TODO   :  页面跳转控制器
 */

@Controller
public class PageController {
    @RequestMapping(value = "/")
    public String asd(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
