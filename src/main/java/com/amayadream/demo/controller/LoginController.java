package com.amayadream.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.controller
 * Author :  Amayadream
 * Date   :  2015.11.26 15:03
 * TODO   :
 */

@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}
