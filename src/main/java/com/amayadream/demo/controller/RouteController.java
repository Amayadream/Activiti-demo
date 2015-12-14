package com.amayadream.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.controller
 * Author :  Amayadream
 * Date   :  2015.12.08 16:18
 * TODO   :
 */
@Controller
public class RouteController {
    @RequestMapping(value = "")
    public String index(){
        return "/login";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/show")
    public String show(){
        return "/show";
    }

    @RequestMapping(value = "/running")
    public String running(){
        return "/running";
    }

    @RequestMapping(value = "/finished")
    public String finished(){
        return "/finished";
    }

}
