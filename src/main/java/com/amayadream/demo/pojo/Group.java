package com.amayadream.demo.pojo;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.pojo
 * Author :  Amayadream
 * Date   :  2015.12.08 14:46
 * TODO   :  自定义分组类
 */
@Repository
public class Group {
    private String id;      //分组编号
    private String name;    //分组名
    private String type;    //类型

    /**
     * getter&setter
     * @return
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

}
