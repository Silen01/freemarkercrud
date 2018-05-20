package com.liu.service;

import com.liu.dao.UserDAOImpl;
import com.liu.vo.User;

import java.util.List;

/**
 * Created by 26522 on 2018/5/20.
 */
public class UserServiceImpl {

    private UserDAOImpl dao;
    public UserServiceImpl(){
        dao=new UserDAOImpl();
    }
    public boolean register(User user){
        return dao.register(user);
    }
    public List<User> queryAll(){
        return dao.queryAll();
    }
    public boolean del(int id){
        return dao.del(id);
    }
    public User queryId(int id){
        return dao.queryId(id);
    }
    public boolean edit(User user){
        return dao.edit(user);
    }
}
