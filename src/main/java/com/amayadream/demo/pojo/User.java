package com.amayadream.demo.pojo;

import org.springframework.stereotype.Repository;

/**
 * NAME   :  SSM-demo/com.amayadream.demo.pojo
 * Author :  Amayadream
 * Date   :  2015.11.21 23:17
 * TODO   :
 */

@Repository("user")
public class User {
    public int id;
    public String username;
    public String password;
}
