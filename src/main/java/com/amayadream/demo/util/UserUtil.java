package com.amayadream.demo.util;

import org.activiti.engine.identity.User;

import javax.servlet.http.HttpSession;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.util
 * Author :  Amayadream
 * Date   :  2015.11.26 14:59
 * TODO   :  用户工具类
 */
public class UserUtil {
    public static final String USER = "user";

    /**
     * 设置用户到session
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, User user) {
        session.setAttribute(USER, user);
    }

    /**
     * 从Session获取当前用户信息
     * @param session
     * @return
     */
    public static User getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (User) attribute;
    }
}
