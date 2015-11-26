package com.amayadream.demo.pojo;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.pojo
 * Author :  Amayadream
 * Date   :  2015.11.26 10:46
 * TODO   :  Activiti中ACT_ID_GROUP表的实体类
 */
@Repository("group")
public class Group {

    private String id;
    private String name;
    private String type;
    private List<User> actIdUsers;

    /**
     * getter&setter
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getActIdUsers() {
        return actIdUsers;
    }

    public void setActIdUsers(List<User> actIdUsers) {
        this.actIdUsers = actIdUsers;
    }
}
