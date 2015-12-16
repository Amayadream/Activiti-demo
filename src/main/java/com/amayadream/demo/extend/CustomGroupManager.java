package com.amayadream.demo.extend;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.extend
 * Author :  Amayadream
 * Date   :  2015.12.15 14:48
 * TODO   :
 */
import java.util.ArrayList;
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
        System.out.println("createNewGroup");
        return super.createNewGroup(groupId);
    }

    public void insertGroup(Group group) {
        // TODO Auto-generated method stub
        System.out.println("insertGroup");
        super.insertGroup(group);
    }

    public void updateGroup(Group updatedGroup) {
        // TODO Auto-generated method stub
        System.out.println("updateGroup");
        super.updateGroup(updatedGroup);
    }

    public void deleteGroup(String groupId) {
        // TODO Auto-generated method stub
        System.out.println("deleteGroup");
        super.deleteGroup(groupId);
    }

    //创建查询
    public GroupQuery createNewGroupQuery() {
        // TODO Auto-generated method stub
        System.out.println("createNewGroupQuery");
        return super.createNewGroupQuery();
    }

    //获取所有的分组列表,QueryCriteria是查询附加的条件
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
        // TODO Auto-generated method stub
        System.out.println("findGroupByQueryCriteria");
        Group group = new GroupEntity();
        group.setId("teacher");
        group.setName("臭傻逼");
        group.setType("assignment");
        List<Group> list = new ArrayList<Group>();
        list.add(group);
        return list;
//        return super.findGroupByQueryCriteria(query, page);
    }

    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        // TODO Auto-generated method stub
        System.out.println("findGroupCountByQueryCriteria");
        return super.findGroupCountByQueryCriteria(query);
    }

    //需要重写,分次使用
    public List<Group> findGroupsByUser(String userId) {
        // TODO Auto-generated method stub
        System.out.println("group=>findGroupsByUser");
        Group group = new GroupEntity();
        group.setId("student");
        group.setName("臭傻逼");
        group.setType("assignment");
        List<Group> list = new ArrayList<Group>();
        list.add(group);
        return list;
//        return super.findGroupsByUser(userId);
    }

    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        // TODO Auto-generated method stub
        System.out.println("findGroupsByNativeQuery");
        return super.findGroupsByNativeQuery(parameterMap, firstResult, maxResults);
    }

    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        // TODO Auto-generated method stub
        System.out.println("findGroupCountByNativeQuery");
        return super.findGroupCountByNativeQuery(parameterMap);
    }

    public boolean isNewGroup(Group group){
        System.out.println("isNewGroup");
        return super.isNewGroup(group);
    }
}