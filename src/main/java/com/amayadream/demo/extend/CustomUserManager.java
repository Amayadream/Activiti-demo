package com.amayadream.demo.extend;

import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.extend
 * Author :  Amayadream
 * Date   :  2015.12.15 14:52
 * TODO   :  自定义的Activiti用户组管理器
 */
public class CustomUserManager extends UserEntityManager {

    public User createNewUser(String userId) {
        // TODO Auto-generated method stub
        return super.createNewUser(userId);
    }

    public void insertUser(User user) {
        // TODO Auto-generated method stub
        super.insertUser(user);
    }

    public void updateUser(UserEntity updatedUser) {
        // TODO Auto-generated method stub
        super.updateUser(updatedUser);
    }

    //这里修改了,原先是UserManage
    public User findUserById(String userId) {
        // TODO Auto-generated method stub
        return super.findUserById(userId);
    }

    public void deleteUser(String userId) {
        // TODO Auto-generated method stub
        super.deleteUser(userId);
    }

    public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
        // TODO Auto-generated method stub
        return super.findUserByQueryCriteria(query, page);
    }

    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        // TODO Auto-generated method stub
        return super.findUserCountByQueryCriteria(query);
    }

    public List<Group> findGroupsByUser(String userId) {
        return super.findGroupsByUser(userId);
    }

    public UserQuery createNewUserQuery() {
        // TODO Auto-generated method stub
        return super.createNewUserQuery();
    }

    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
        // TODO Auto-generated method stub
        return super.findUserInfoByUserIdAndKey(userId, key);
    }

    public List<String> findUserInfoKeysByUserIdAndType(String userId, String type) {
        // TODO Auto-generated method stub
        return super.findUserInfoKeysByUserIdAndType(userId, type);
    }

    public Boolean checkPassword(String userId, String password) {
        // TODO Auto-generated method stub
        return super.checkPassword(userId, password);
    }

    public List<User> findPotentialStarterUsers(String proceDefId) {
        // TODO Auto-generated method stub
        return super.findPotentialStarterUsers(proceDefId);
    }

    public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        // TODO Auto-generated method stub
        return super.findUsersByNativeQuery(parameterMap, firstResult, maxResults);
    }

    public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
        // TODO Auto-generated method stub
        return super.findUserCountByNativeQuery(parameterMap);
    }


}