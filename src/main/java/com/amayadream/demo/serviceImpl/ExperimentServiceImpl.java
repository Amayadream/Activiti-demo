package com.amayadream.demo.serviceImpl;

import com.amayadream.demo.dao.IExperimentDao;
import com.amayadream.demo.pojo.Experiment;
import com.amayadream.demo.service.IExperimentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.serviceImpl
 * Author :  Amayadream
 * Date   :  2015.12.08 15:28
 * TODO   :
 */
@Service("experimentService")
public class ExperimentServiceImpl implements IExperimentService {
    @Resource private IExperimentDao experimentDao;
    @Resource private Experiment experiment;

    public List<Experiment> selectAll() {
        return experimentDao.selectAll();
    }

    public Experiment selectExperimentById(String id) {
        return experimentDao.selectExperimentById(id);
    }

    public Experiment selectExperimentByUserid(String userid) {
        return experimentDao.selectExperimentByUserid(userid);
    }

    public boolean insert(String userid, String processinstanceid, String taskid, String starttime, String endtime) {
        experiment.setUserid(userid);
        experiment.setProcessinstanceid(processinstanceid);
        experiment.setTaskid(taskid);
        experiment.setStarttime(starttime);
        experiment.setEndtime(endtime);
        return experimentDao.insert(experiment);
    }

    public boolean update(String id, String userid, String processinstanceid, String taskid, String starttime, String endtime) {
        experiment.setId(id);
        experiment.setUserid(userid);
        experiment.setProcessinstanceid(processinstanceid);
        experiment.setTaskid(taskid);
        experiment.setStarttime(starttime);
        experiment.setEndtime(endtime);
        return experimentDao.update(experiment);
    }

    public boolean delete(String id) {
        return experimentDao.delete(id);
    }
}
