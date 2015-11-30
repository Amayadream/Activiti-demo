package com.amayadream.demo.service;


import com.amayadream.demo.pojo.Leave;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.service
 * Author :  Amayadream
 * Date   :  2015.11.30 15:26
 * TODO   :
 */
public interface ILeaveService {
    List<Leave> selectAll();
    Leave selectLeaveById(String id);
    boolean insert(Leave leave);
    boolean update(Leave leave);
}
