package com.amayadream.demo.extend;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.extend
 * Author :  Amayadream
 * Date   :  2015.12.15 14:48
 * TODO   :
 */
import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;

/**
 * 自定义的Activiti用户组管理器
 *
 */
public class CustomGroupManager extends GroupEntityManager {

    public Group createNewGroup(String groupId) {
        // TODO Auto-generated method stub
        return super.createNewGroup(groupId);
    }

    public void insertGroup(Group group) {
        // TODO Auto-generated method stub
        super.insertGroup(group);
    }

    public void updateGroup(GroupEntity updatedGroup) {
        // TODO Auto-generated method stub
        super.updateGroup(updatedGroup);
    }

    public void deleteGroup(String groupId) {
        // TODO Auto-generated method stub
        super.deleteGroup(groupId);
    }

    public GroupQuery createNewGroupQuery() {
        // TODO Auto-generated method stub
        return super.createNewGroupQuery();
    }

    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
        // TODO Auto-generated method stub
        return super.findGroupByQueryCriteria(query, page);
    }

    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        // TODO Auto-generated method stub
        return super.findGroupCountByQueryCriteria(query);
    }

    public List<Group> findGroupsByUser(String userId) {
        // TODO Auto-generated method stub
        return super.findGroupsByUser(userId);
    }

    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        // TODO Auto-generated method stub
        return super.findGroupsByNativeQuery(parameterMap, firstResult, maxResults);
    }

    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        // TODO Auto-generated method stub
        return super.findGroupCountByNativeQuery(parameterMap);
    }
}