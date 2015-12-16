package com.amayadream.demo.controller;

import com.amayadream.demo.util.UserUtil;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.controller
 * Author :  Amayadream
 * Date   :  2015.12.08 16:18
 * TODO   :
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired private IdentityService identityService;

    /**
     * 登录系统
     * @param username  用户名
     * @param password  密码
     * @param session   session
     * @return
     */
    @RequestMapping(value = "/login")
    public String logon(String username, String password, HttpSession session) {
        logger.debug("login request: {username={}, password={}}", username, password);
        boolean checkPassword = identityService.checkPassword(username, password);
        if (checkPassword) {
            //读取用户
            User user = identityService.createUserQuery().userId(username).singleResult();
            UserUtil.saveUserToSession(session, user);
            //读取用户组
//            List<Group> groupList = identityService.createGroupQuery().groupMember(username).list();
//            session.setAttribute("groups", groupList);
//            String[] groupnames = new String[groupList.size()];
//            for (int i = 0; i < groupnames.length; i++) {
//                System.out.println(groupList.get(i).getName());
//                groupnames[i] = groupList.get(i).getName();
//            }
//            session.setAttribute("groupnames", ArrayUtils.toString(groupnames));
            return "redirect:/experiment/list/task";
        } else {
            return "redirect:/login?error=true";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("groups");
        session.removeAttribute("groupnames");
        return "/login";
    }
}
