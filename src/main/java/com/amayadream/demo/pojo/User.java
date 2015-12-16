package com.amayadream.demo.pojo;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.pojo
 * Author :  Amayadream
 * Date   :  2015.12.08 14:40
 * TODO   :  自定义用户实体类
 */
@Repository
public class User {
    private String username;    //用户名
    private String password;    //密码
    private String firstname;   //姓
    private String lastname;    //名
    private String email;       //邮箱

    /**
     * getter&setter
     * @return
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
