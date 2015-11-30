package com.amayadream.demo.dao;

import com.amayadream.demo.pojo.Leave;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.dao
 * Author :  Amayadream
 * Date   :  2015.11.30 15:26
 * TODO   :
 */
@Service("leaveDao")
public interface ILeaveDao{
    List<Leave> selectAll();
    Leave selectLeaveById(String id);
    boolean insert(Leave leave);
    boolean update(Leave leave);
}
