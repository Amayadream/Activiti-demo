package com.amayadream.demo.dao;

import com.amayadream.demo.pojo.Experiment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.dao
 * Author :  Amayadream
 * Date   :  2015.12.08 15:24
 * TODO   :
 */
@Service("experimentDao")
public interface IExperimentDao {
    List<Experiment> selectAll();
    Experiment selectExperimentById(String id);
    Experiment selectExperimentByUserid(String userid);
    boolean insert(Experiment experiment);
    boolean update(Experiment experiment);
    boolean delete(String id);
}
