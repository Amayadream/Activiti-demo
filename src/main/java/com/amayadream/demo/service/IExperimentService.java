package com.amayadream.demo.service;

import com.amayadream.demo.pojo.Experiment;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.service
 * Author :  Amayadream
 * Date   :  2015.12.08 15:27
 * TODO   :
 */
public interface IExperimentService {
    List<Experiment> selectAll();
    Experiment selectExperimentById(String id);
    Experiment selectExperimentByUserid(String userid);
    boolean insert(String userid, String processinstanceid, String taskid, String starttime, String endtime);
    boolean update(String id, String userid, String processinstanceid, String taskid, String starttime, String endtime);
    boolean delete(String id);
}
