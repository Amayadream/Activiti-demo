package com.amayadream.demo.pojo;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NAME   :  SSM-demo/com.amayadream.demo.pojo
 * Author :  Amayadream
 * Date   :  2015.11.21 23:17
 * TODO   :  Activiti中ACT_ID_USER表的实体类
 */

@Repository("user")
public class User {
    private String id;
    private String email;
    private String first;
    private String last;
    private String password;
    private List<Group> actIdGroups;

    /**
     * getter&setter
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Group> getActIdGroups() {
        return actIdGroups;
    }

    public void setActIdGroups(List<Group> actIdGroups) {
        this.actIdGroups = actIdGroups;
    }
}
