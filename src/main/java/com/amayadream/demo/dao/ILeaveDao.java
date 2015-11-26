package com.amayadream.demo.dao;

import com.amayadream.demo.pojo.Leave;
import org.springframework.data.repository.CrudRepository;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.dao
 * Author :  Amayadream
 * Date   :  2015.11.26 14:33
 * TODO   :  请假实体管理接口
 */
public interface ILeaveDao {
    public interface LeaveDao extends CrudRepository<Leave, Long> {
    }
}
